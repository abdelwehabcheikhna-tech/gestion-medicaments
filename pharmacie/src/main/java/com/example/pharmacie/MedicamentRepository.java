package com.example.pharmacie;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
// JpaRepository<Medicament, Long> :
// - Medicament = la classe Entity
// - Long = le type de l'id
public interface MedicamentRepository
        extends JpaRepository<Medicament, Long> {
    // Recherche par nom (contient le mot, sans casse)
// Spring génère le SQL automatiquement grâce au nom de la méthode !
    List<Medicament> findByNomContainingIgnoreCase(String nom);}