package com.example.pharmacie;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // <- Dit à Spring : cette classe = une table MySQL
@Table(name = "medicaments") // <- Nom de la table
public class Medicament {
    @Id // <- Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <- AUTO_INCREMENT
    private Long id;
    @Column(nullable = false) // <- NOT NULL
    private String nom;
    private BigDecimal prix;
    private Integer quantite;
    private LocalDate expiration; // <- DATE MySQL
    // nn Getters et Setters (obligatoires) nnnnnnnnnnnnnn
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public LocalDate getExpiration() { return expiration; }
    public void setExpiration(LocalDate expiration){ this.expiration = expiration; }}