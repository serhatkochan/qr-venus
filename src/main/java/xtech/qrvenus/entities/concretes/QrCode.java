package xtech.qrvenus.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "qr_codes") // veya bunu qrCodes yazacaz duruma göre.
@Entity // ORM Tech
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // yazılabilir ama gerek var mı bi kontrol et.
    private Integer id; // Integer, Integer, Long ???

    private String title;

    private String note;

    @Column(name = "code", unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "qr_code_permissions_qr_codes",
            joinColumns = @JoinColumn(name = "qr_code_id"),
            inverseJoinColumns = @JoinColumn(name = "qr_code_permission_id"))
    private List<QrCodePermission> qrCodePermissions;
}
