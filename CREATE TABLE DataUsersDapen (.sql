CREATE TABLE DataUsersDapen (
    id INT NOT NULL AUTO_INCREMENT,
    MyUsername varchar(255) NOT NULL,
    MyPassword varchar(255) NOT NULL,
    MyUsia int NOT NULL,
    MyUsiaPensi int NOT NULL,
    MyAkhirPensi int NOT NULL,
    MyDurasiPensi int NOT NULL,
    MyKelamin INT NOT NULL,
    MyBulan DOUBLE NOT NULL,
    MyTahun INT NOT NULL,
    MyBungaFinal DOUBLE NOT NULL,
    MyArrPengeluaran DOUBLE NOT NULL,
    MyArrTabunganUser LONG NOT NULL,
    MyAngsuran DOUBLE NOT NULL,
    Mycountbarispembuku INT NOT NULL,
    PRIMARY KEY (id)
);