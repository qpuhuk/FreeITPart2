package HomeWorks.HW5.hibernate.controller.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private int age;
    @NotNull
    private String name;
    private AddressDto address;
}
