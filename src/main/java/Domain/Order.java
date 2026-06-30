package Domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="Orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Order
{
    @Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
private String name;
private LocalDateTime orderDate;
private  BigDecimal price;

public  Order( String name,BigDecimal price, LocalDateTime orderDate)
{
    if (price.compareTo(BigDecimal.ZERO)<0)
        throw new IllegalArgumentException("Ошибка цена не может быть меньше нуля");

    if (name == null || name.isBlank())
        throw  new IllegalArgumentException("Ошибка имени");

    this.name = name;
    this.price = price;
    this.orderDate = orderDate;
}

public  void updateorder(String name,BigDecimal price, LocalDateTime orderDate)
{
    this.name=name;
    this.price = price;
    this.orderDate = orderDate;
}
}
