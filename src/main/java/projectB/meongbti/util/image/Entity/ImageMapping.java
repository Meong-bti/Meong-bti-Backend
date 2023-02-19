package projectB.meongbti.util.image.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageMapping {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imId;
    private String imUpload;
    private String imStore;

    public ImageMapping(String imUpload, String imStore) {
        this.imUpload = imUpload;
        this.imStore = imStore;
    }

}
