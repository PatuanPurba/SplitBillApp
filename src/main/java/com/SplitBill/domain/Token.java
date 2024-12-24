package com.SplitBill.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public UUID getId() {return id;}
}
