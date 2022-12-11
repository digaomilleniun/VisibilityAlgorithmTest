package br.com.rpires.VisibilityAlgorithmTest.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "stock")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long sizeId;

    @NotNull
    @Column(nullable = false)
    private Long quantity;
}
