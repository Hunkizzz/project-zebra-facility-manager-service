package persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "issue")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    private UUID uuid;

}
