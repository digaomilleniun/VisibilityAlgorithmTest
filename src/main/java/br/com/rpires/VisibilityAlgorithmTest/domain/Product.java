package br.com.rpires.VisibilityAlgorithmTest.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "product")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String sequence;
}
