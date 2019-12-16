package mowei.master1_car.carmanager.model.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import mowei.master1_car.carmanager.model.BaseModel;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "t_test")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TestModel extends BaseModel implements Serializable {

    @Column(name = "name", unique = true, nullable = false, length = 20)
    String name;
    @Column(name = "password", nullable = false, length = 20)
    String password;
    @Column(name = "age")
            @ColumnDefault("0")
    Integer age;
}
