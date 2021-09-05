package com.example.demo4.controller;

import com.example.demo4.model.Board;
import com.example.demo4.repository.BoardRepository;
import com.example.demo4.service.BoardService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<Board>> all(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String content) {
        if (boardService.findAll(title, content) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(boardService.findAll(title, content), HttpStatus.OK);
        }
    }

    @PostMapping("/boards")
    public ResponseEntity<Board> newBoard(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.saveOne(board), HttpStatus.CREATED);
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<Board> one(@ApiParam(value = "게시글 번호", required = true, example = "1")@PathVariable Long id) {
        if (boardService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(boardService.findOne(id), HttpStatus.OK);
        }
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<Board> replaceBoard(@PathVariable Long id, @RequestBody Board newBoard) {
        return new ResponseEntity<>(boardService.updateById(id, newBoard), HttpStatus.OK);
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id) {
        if (boardService.deleteOne(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/boards")
    public ResponseEntity<Board> deleteAll() {
        boardService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
