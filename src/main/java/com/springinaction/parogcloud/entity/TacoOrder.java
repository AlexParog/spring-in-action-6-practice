package com.springinaction.parogcloud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Класс, представляющий заказ.
 */
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tacoOrder")
@Table(name = "taco_order")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Delivery name is required")
    @Column(nullable = false)
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Column(nullable = false)
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Column(nullable = false)
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Column(nullable = false)
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(nullable = false)
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    @Column(nullable = false)
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(nullable = false)
    private String ccCVV;

    @Column(nullable = false)
    private Date placedAt;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<Taco> tacos = new HashSet<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
        taco.setOrder(this);
    }

    public void removeTaco(Taco taco) {
        taco.setOrder(null);
        this.tacos.remove(taco);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TacoOrder order = (TacoOrder) o;
        return getId() != null && Objects.equals(getId(), order.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode()
                : getClass().hashCode();
    }

}