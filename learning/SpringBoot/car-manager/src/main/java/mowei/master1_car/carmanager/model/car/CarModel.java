package mowei.master1_car.carmanager.model.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mowei.master1_car.carmanager.model.BaseModel;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarModel extends BaseModel implements Serializable {
    @Column(nullable = false)
            @ColumnDefault("''")
    String carLog,
            carNo,
            carFirstName,
            carLastName,
            carTypeNo,
            carWeight,
            carHeight,
            carWidth,
            carMaxSpeed,
            carAT,
            carMaterial,
            carPrice,
            carAge,
            carSeatNo,
            carColor,
            carRunKM,
            carCountry,
            carSpecial,
            carOil;
}
