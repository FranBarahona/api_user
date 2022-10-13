package com.user.api_user.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents", schema = "users")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idDocument;

    @ManyToOne
    @JoinColumn(name = "id_type_document" , updatable = false)
    private TypeDocument idTypeDocument;

    @ManyToOne
    @JoinColumn(name = "id_user" , updatable=false)
    private Users idUser;

    @Column(name = "document")
    private String document;

}
