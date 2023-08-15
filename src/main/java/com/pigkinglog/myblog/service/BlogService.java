package com.pigkinglog.myblog.service;

import com.pigkinglog.myblog.domain.Article;
import com.pigkinglog.myblog.dto.AddArticleRequest;
import com.pigkinglog.myblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 모든 글을 조회하는 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }


    public Article findById (long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete (long id) {
        blogRepository.deleteById(id);
    }

}