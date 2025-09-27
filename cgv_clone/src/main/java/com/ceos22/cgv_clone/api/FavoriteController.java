package com.ceos22.cgv_clone.api;

import com.ceos22.cgv_clone.domain.dto.FavoriteCinemaDto;
import com.ceos22.cgv_clone.domain.dto.FavoriteMovieDto;
import com.ceos22.cgv_clone.service.FavoriteCinemaService;
import com.ceos22.cgv_clone.service.FavoriteMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteCinemaService favoriteCinemaService;
    private final FavoriteMovieService favoriteMovieService;

    // 영화관 찜 목록
    @GetMapping("/cinemas/{memberId}")
    public List<FavoriteCinemaDto> cinemaList(@PathVariable Long memberId) {
        return favoriteCinemaService.list(memberId);
    }

    // 영화 찜 목록
    @GetMapping("/movies/{memberId}")
    public List<FavoriteMovieDto> movieList(@PathVariable Long memberId) {
        return favoriteMovieService.list(memberId);
    }
}