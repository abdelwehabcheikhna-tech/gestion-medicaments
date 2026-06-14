package com.example.pharmacie;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;
@RestController // <- Retourne du JSON automatiquement
@RequestMapping("/medicaments") // <- Préfixe de toutes les routes
@CrossOrigin(origins = "*") // <- Autorise React à appeler cette API
public class MedicamentController {
    private final MedicamentService service;
    public MedicamentController(MedicamentService service) {
        this.service = service;
    }
    // GET /medicaments -> Liste tous
    @GetMapping
    public List<Medicament> lireTous() {
        return service.lireTous();
    }
    // GET /medicaments/search?q=para -> Recherche
    @GetMapping("/search")
    public List<Medicament> chercher(@RequestParam String q) {
        return service.chercher(q);
    }
    // GET /medicaments/3 -> Un seul médicament
    @GetMapping("/{id}")
    public ResponseEntity<Medicament> lireUn(@PathVariable Long id) {
        return service.lireUn(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // POST /medicaments -> Ajouter
    @PostMapping
    public Medicament ajouter(@RequestBody Medicament m) {
        return service.sauvegarder(m);
    }
    // PUT /medicaments/3 -> Modifier
    @PutMapping("/{id}")
    public ResponseEntity<Medicament> modifier(
            @PathVariable Long id,
            @RequestBody Medicament nouvelles) {return service.lireUn(id).map(m -> {
        m.setNom(nouvelles.getNom());
        m.setPrix(nouvelles.getPrix());
        m.setQuantite(nouvelles.getQuantite());
        m.setExpiration(nouvelles.getExpiration());
        return ResponseEntity.ok(service.sauvegarder(m));
    }).orElse(ResponseEntity.notFound().build());
    }
    // DELETE /medicaments/3 -> Supprimer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}