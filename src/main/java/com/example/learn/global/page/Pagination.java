package com.example.learn.global.page;

public record Pagination(
        Integer pageNo,
        Integer offset,
        Direction direction
) {
    public static Pagination of(Integer pageNo, Integer offset, String direction) {
        return new Pagination(
                pageNo, offset, Direction.valueOf(direction)
        );
    }
}
