package com.example.demo4.service;

import com.example.demo4.model.Board;
import com.example.demo4.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board findOne(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> findAll(String title, String content) {
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findByTitleOrContent(title, content);
        }
    }

    public Board saveOne(Board board) {
        return boardRepository.save(board);
    }

    public Board updateById(Long id, Board newBoard) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }

    public boolean deleteOne(@PathVariable Long id) {
        if (boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAll() {
        boardRepository.deleteAll();
        return true;
    }
}
