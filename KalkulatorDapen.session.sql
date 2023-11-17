connect;

ALTER TABLE DataUsersDapen MODIFY MyUsername VARCHAR(255) DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyPassword VARCHAR(255) DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyUsia INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyUsiaPensi INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyAkhirPensi INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyDurasiPensi INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyKelamin INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyBulan DOUBLE DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyTahun INT DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyBungaFinal DOUBLE DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyArrPengeluaran DOUBLE DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyArrTabunganUser LONG DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY MyAngsuran DOUBLE DEFAULT NULL;
ALTER TABLE DataUsersDapen MODIFY Mycountbarispembuku INT DEFAULT NULL;

INSERT INTO datausersdapen (MyArrPengeluaran) VALUES ("10000");

UPDATE TABLE DataUsersDapen
ADD MyAngsuranHutang DOUBLE AFTER Mycountbarispembuku;

UPDATE TABLE DataUsersDapen
ADD MyAngsuranUser DOUBLE AFTER MyAngsuranHutang;

CREATE TABLE DataUsersDapen (
    id INT NOT NULL AUTO_INCREMENT,
    MyUsername varchar(255),
    MyPassword varchar(255),
    MyUsia int,
    MyUsiaPensi int,
    MyAkhirPensi int,
    MyDurasiPensi int,
    MyKelamin int,
    MyBulan double,
    MyTahun int,
    MyBungaFinal double,
    MyArrPengeluaran double,
    MyArrTabunganUser LONG,
    MyAngsuran DOUBLE,
    Mycountbarispembuku int,
    PRIMARY KEY (id)
);

CREATE TABLE PembukuanDapen (
    id INT AUTO_INCREMENT,
    MyAngsuranHutang DOUBLE,
    MyAngsuranUser DOUBLE,
    PRIMARY KEY (id)
)