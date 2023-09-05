package ru.jordan.spring.computerworkshop.ComputerWorkshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.models.Board;
import ru.jordan.spring.computerworkshop.ComputerWorkshop.repositories.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findOne(int id) {
        Optional<Board> foundBoard = boardRepository.findById(id);

        return foundBoard.orElse(null);

    }

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void update(int id, Board updateboard) {
        updateboard.setId(id);
        boardRepository.save(updateboard);
    }

    @Transactional
    public void delete(int id) {
        boardRepository.deleteById(id);
    }

}
