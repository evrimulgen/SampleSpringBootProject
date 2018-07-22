package tr.com.dev.haliYikama.server.utils;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class EnumUtil {

    public enum EntityState {
        PASSIVE(0, "Pasif"), ACTIVE(1, "Aktif");
        private final Integer id;
        private final String name;

        private EntityState(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public static EntityState parse(Integer id) {
            for (EntityState entityState : EntityState.values()) {
                if (entityState.getId().equals(id)) {
                    return entityState;
                }
            }
            return null;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public enum YETKI_TYPE {
        CALISAN, FIRMA_YETKILISI, SUPER_ADMIN
    }

    public enum ADRES_TYPE {
        EV, IS, GENEL
    }

    public enum ADRES_USER_TYPE {
        FIRMA_PERSONELI, FIRMA, MUSTERI, GENEL
    }

    public enum TEL_TYPE {
        CEP, EV, IS, FAX
    }

    public enum ODEME_TYPE {
        AYLIK, YILLIK
    }

    public enum URUN_CINSI {
        ADET, KILOGRAM, GRAM, METREKARE
    }

    public enum SIPARIS_DURUMU {
        TESLIM_EDILECEK, TESLIME_HAZIR, TESLIM_EDILDI
    }


}
