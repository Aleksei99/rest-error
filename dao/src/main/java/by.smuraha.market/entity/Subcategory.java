package by.smuraha.market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "subcategories")
public class Subcategory extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subcategory",fetch = FetchType.EAGER)
    private List<Product> products;

    public Subcategory(Category category, String name) {
        this.category = category;
        this.name = name;
    }
}
