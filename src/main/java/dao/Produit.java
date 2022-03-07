package dao;
import lombok.*;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor
@Table(name="PRODUITS")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="REF")
    @NonNull
    private Long reference;
    @Column(name="DES")
    @NonNull
    private String designation;
    @NonNull
    private double prix;
    @NonNull
    private int quantite;


// Constructeur par défaut
// Getters et Setters

}