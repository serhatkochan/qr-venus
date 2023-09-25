package xtech.qrvenus.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "qr_code_permissions")
@Entity // ORM Tech
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrCodePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "qrCodePermissions")
    private List<QrCode> qrCodes;
}