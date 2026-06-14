package com.example.pharmacie;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service // <- Spring gère cette classe automatiquement
public class MedicamentService {
    private final MedicamentRepository repo;
    // Injection de dépendances (Spring donne le Repository automatiquement)
    public MedicamentService(MedicamentRepository repo) {
        this.repo = repo;
    }
    // Lire tous les médicaments
    public List<Medicament> lireTous() {
        return repo.findAll();
    }
    // Rechercher par nom
    public List<Medicament> chercher(String mot) {
        return repo.findByNomContainingIgnoreCase(mot);
    }
    // Lire un médicament par son id
    public Optional<Medicament> lireUn(Long id) {
        return repo.findById(id);
    }
    // Ajouter ou modifier (save() fait les deux !)
    public Medicament sauvegarder(Medicament m) {
        return repo.save(m);
    }
    // Supprimer par id
    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}