package j22_DateTime.GirisProject;

import java.time.LocalDateTime;

    public class Kullanıcı {//kullanıcı obj uretecek kalıphane class -> main olmaz

        String name;//obj de değer alacak inst. var.
        LocalDateTime kayıtZamanı;//obj de değer alacak inst. var.

        public Kullanıcı(String name, LocalDateTime kayıtZamanı) {//full p'li teleskopik cons.
            this.name = name;
            this.kayıtZamanı = kayıtZamanı;
        }

        @Override
        public String toString() {//bu class'dan olusturulan obj print etmek için obj datalarını string'e cevirir
            return
                    "name='" + name + '\'' +
                            ", kayıtZamanı=" + kayıtZamanı;
        }
}
