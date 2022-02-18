package com.azurealstn.blogproject.service;

import com.azurealstn.blogproject.domain.board.Board;
import com.azurealstn.blogproject.domain.board.BoardRepository;
import com.azurealstn.blogproject.domain.user.User;
import com.azurealstn.blogproject.dto.board.BoardSaveRequestDto;
import com.azurealstn.blogproject.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
        boardSaveRequestDto.setUser(user);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<Board> findByTitleContainsOrContentContains(String title, String content, Pageable pageable) {
        return boardRepository.findByTitleContainsOrContentContains(title, content, pageable);
    }

    @Transactional
    public Board detail(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return id;
    }

    @Transactional
    public void updateCount(Long id) {
        boardRepository.updateCount(id);
    }
}
