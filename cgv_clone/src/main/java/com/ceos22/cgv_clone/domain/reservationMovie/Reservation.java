package com.ceos22.cgv_clone.domain.reservationMovie;


import com.ceos22.cgv_clone.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="reservation")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="screening_id", nullable=false)
    private Screening screening;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status = ReservationStatus.CREATED;

    @Column(nullable=false)
    private int totalAmount; // 스냅샷 합계

    @Column(nullable=false)
    private LocalDateTime reservedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    public Reservation(Member member, Screening screening) {
        this.member = member; this.screening = screening;
    }

    public void addTicket(Ticket t){
        tickets.add(t);
        t.setReservation(this);
        totalAmount += t.getUnitPrice();
    }

    public void markPaid(){ this.status = ReservationStatus.PAID; }
    public void cancel(){ this.status = ReservationStatus.CANCELLED; }
}
