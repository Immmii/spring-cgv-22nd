package com.ceos22.cgv_clone.domain.reservationMovie;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Table(name = "seat_template")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatTemplate {
    @Id
    private Long id; // auditorium_type.id 와 공유

    @OneToOne(fetch = FetchType.LAZY) @MapsId
    @JoinColumn(name = "auditorium_type_id")
    private AuditoriumType auditoriumType;

    @Column(nullable=false) private int row; // rows
    @Column(nullable=false) private int col; // cols

    public SeatTemplate(AuditoriumType type, int row, int col) {
        if (row <= 0 || col <= 0) throw new IllegalArgumentException("row/col > 0");
        this.auditoriumType = type; this.row = row; this.col = col;
    }
}