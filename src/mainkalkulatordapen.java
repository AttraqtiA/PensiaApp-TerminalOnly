import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Random;

public class mainkalkulatordapen {

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            mainkalkulatordapen fun = new mainkalkulatordapen();

            int count_user = 0;
            double pengeluaran = 0, inflasi_n = 0;
            long tabunganUser = 0; // ??? hapus kalo ga mudeng
            double bunga_n, save1 = 0, save2 = 0, save3 = 0;
            String username_n = "";
            ArrayList<Double> arrpengeluaran = new ArrayList<Double>();
            ArrayList<Long> arrtabunganUser = new ArrayList<Long>();
            ArrayList<Integer> kelamin = new ArrayList<Integer>();
            ArrayList<Integer> usia = new ArrayList<Integer>();
            ArrayList<Integer> usiapensi = new ArrayList<Integer>();
            ArrayList<Integer> akhirpensi = new ArrayList<Integer>();
            ArrayList<Integer> durasipensi = new ArrayList<Integer>();
            ArrayList<String> username = new ArrayList<String>();
            ArrayList<String> password_acc = new ArrayList<String>();
            String password_n = "";
            int tahun_n = 0, kelamin_n = 0, usia_n = 0, usiapensi_n = 0, akhirpensi_n = 0, durasipensi_n = 0;
            ArrayList<Double> inflasi = new ArrayList<Double>();
            ArrayList<Double> bunga = new ArrayList<Double>();
            ArrayList<Double> bungafinal = new ArrayList<Double>();
            ArrayList<Double> bulan = new ArrayList<Double>();
            ArrayList<Integer> tahun = new ArrayList<Integer>();
            ArrayList<Double> angsuran = new ArrayList<Double>();
            Double[][] angsuran_hutang2D = new Double[9999][9999];
            Double[][] angsuran_user2D = new Double[9999][9999];
            ArrayList<Integer> countbarispembuku = new ArrayList<Integer>();

            int count_a = 0, count_b = 0, count_c = 0, count_d = 0;

            while (true) {
                System.out.print(
                        "\n-------------------------------------------\nSelamat datang di Pensia\nSiap Siaga Menyiapkan Masa Yang Ceria\n-------------------------------------------\nMENU\n"
                                + "1. Register\n2. Log in untuk Pembukuan\n3. Delete Account\n0. Keluar\nKetikkan angka : ");
                String opsi = s.next() + s.nextLine();

                // REGISTER
                if (opsi.equals("1")) {
                    System.out.print(
                            "-------------------------------------------\nPEMBUATAN AKUN\n-------------------------------------------\nHarap masukkan data pribadi anda :\nUsername : ");
                    username_n = s.next() + s.nextLine();
                    username.add(username_n);

                    while (true) {
                        System.out.print(
                                "-------------------------------------------\n1. Password minimal 8 karakter\n2. Password harus menyertakan setidaknya 1 huruf dan 1 angka\n3. Special character (!?/*&...) tidak diperbolehkan\nPassword : ");
                        password_n = s.next() + s.nextLine();
                        char[] passpisah = password_n.toCharArray();
                        int count1 = 0, count2 = 0;
                        String angka = "1234567890";
                        char[] listangka = angka.toCharArray();
                        String alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        char[] listalfa = alfa.toCharArray();
                        if (passpisah.length >= 8) {
                            for (int a = 0; a < passpisah.length; a++) {
                                for (int b = 0; b < listangka.length; b++) {
                                    if (passpisah[a] == listangka[b]) {
                                        count1++;
                                    } else {

                                    }
                                }
                            }
                            for (int a = 0; a < passpisah.length; a++) {
                                for (int b = 0; b < listalfa.length; b++) {
                                    if (passpisah[a] == listalfa[b]) {
                                        count2++;
                                        break;
                                    } else {

                                    }
                                }
                            }

                            int validgak = fun.validcheck(count1, count2, passpisah, password_n);
                            if (validgak == 1) {
                                System.out.println("--Password is valid!--");
                                password_acc.add(password_n);
                                break;
                            } else {
                                System.out.println(
                                        "--Password is NOT valid! : (minimal 8, terdiri dari minimal 1 kata dan 1 angka, no special char!)--");
                            }
                        } else {
                            System.out.println(
                                    "--Password is NOT valid! : (minimal 8, terdiri dari minimal 1 kata dan 1 angka, no special char!)--");
                        }
                    }

                    int count = 0;

                    String kelamin_s;
                    while (true) {
                        System.out.print(
                                "-------------------------------------------\nJenis kelamin :\n1. Pria\n2. Wanita\nKetikkan angka : ");
                        kelamin_s = s.next() + s.nextLine();
                        count = fun.angkachecker(kelamin_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            if (kelamin.size() == count_a) {
                                kelamin.add(Integer.parseInt(kelamin_s));
                                kelamin_n = kelamin.get(count_a);
                            } else if (kelamin.size() == count_a + 1) {
                                kelamin.set(count_a, Integer.parseInt(kelamin_s));
                                kelamin_n = kelamin.get(count_a);
                            }
                            if (kelamin_n == 1 || kelamin_n == 2) {
                                break;
                            } else {
                                System.out.println("--Jenis kelamin tidak dikenal--");
                            }
                        }

                    }
                    count_a++;

                    String usia_s;
                    while (true) {
                        System.out
                                .print("-------------------------------------------\nMasukkan usia anda (18 - 70) : ");
                        usia_s = s.next() + s.nextLine();
                        count = fun.angkachecker(usia_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            if (usia.size() == count_b) {
                                usia.add(Integer.parseInt(usia_s));
                                usia_n = usia.get(count_b);
                            } else if (kelamin.size() == count_b + 1) {
                                usia.set(count_b, Integer.parseInt(usia_s));
                                usia_n = usia.get(count_b);
                            }
                            if (usia_n >= 18 && usia_n <= 70) {
                                break;
                            } else {
                                System.out.println("--Usia di luar range 18 - 70--");
                            }
                        }
                    }
                    count_b++;

                    String usiapensi_s;
                    while (true) {
                        if (usia_n < 55) {
                            System.out.print(
                                    "-------------------------------------------\nPada usia berapa anda berencana mulai pensiun? (55 - 70) : ");
                        } else {
                            System.out.print(
                                    "-------------------------------------------\nPada usia berapa anda berencana mulai pensiun? ("
                                            + (usia_n + 1) + " - 70) : ");
                        }
                        usiapensi_s = s.next() + s.nextLine();
                        count = fun.angkachecker(usiapensi_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            if (usiapensi.size() == count_c) {
                                usiapensi.add(Integer.parseInt(usiapensi_s));
                                usiapensi_n = usiapensi.get(count_c);
                            } else if (kelamin.size() == count_c + 1) {
                                usiapensi.set(count_c, Integer.parseInt(usiapensi_s));
                                usiapensi_n = usiapensi.get(count_c);
                            }
                            if (usia_n < 55) {
                                if (usiapensi_n >= 55 && usiapensi_n <= 70) {
                                    break;
                                } else {
                                    System.out.println("--Usia rencana mulai pensiun di luar range 55 - 70--");
                                }
                            } else {
                                if (usiapensi_n >= (usia_n + 1) || usiapensi_n <= 70) {
                                    break;
                                } else {
                                    System.out.println("--Usia rencana mulai pensiun di luar range 55 - 70--");
                                }
                            }
                        }
                    }
                    count_c++;

                    String akhirpensi_s;
                    while (true) {
                        while (true) {
                            System.out.print(
                                    "-------------------------------------------\nTahun pensiun akhir untuk menentukan durasi masa pensiun (minimal usia "
                                            + (usiapensi_n) + " tahun dan maksimum 99 tahun) yaitu : ");
                            akhirpensi_s = s.next() + s.nextLine();
                            count = fun.angkachecker(akhirpensi_s);
                            if (count >= 1) {
                                System.out.println("--Input harus berupa angka--");
                            } else {
                                if (akhirpensi.size() == count_d) {
                                    akhirpensi.add(Integer.parseInt(akhirpensi_s));
                                    akhirpensi_n = akhirpensi.get(count_d);
                                } else if (kelamin.size() == count_d + 1) {
                                    akhirpensi.set(count_d, Integer.parseInt(akhirpensi_s));
                                    akhirpensi_n = akhirpensi.get(count_d);
                                }
                                if (akhirpensi_n <= 99 && akhirpensi_n >= (usiapensi_n)) {
                                    break;
                                } else {
                                    System.out.println(
                                            "--Usia melebihi range " + (usiapensi_n) + " hingga 99 tahun--");
                                }
                            }
                        }
                        durasipensi_n = akhirpensi_n - usiapensi_n + 1;
                        System.out.println(
                                "--Anda memilih untuk merencanakan pensiun selama " + durasipensi_n
                                        + " tahun--\nApakah anda yakin? (Y / N)");
                        String choice = s.next() + s.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            durasipensi.add(durasipensi_n);
                            break;
                        } else if (choice.equalsIgnoreCase("N")) {

                        } else {
                            System.out.println("--Opsi dianggap N--");
                        }
                    }
                    count_d++;

                    NumberFormat formatter = NumberFormat.getInstance(new Locale("in", "ID"));
                    formatter.setMaximumFractionDigits(2);
                    formatter.setMinimumFractionDigits(2);
                    formatter.setGroupingUsed(true);

                    System.out.println("\nKehidupan pensiun seperti apa yang Anda inginkan?");
                    System.out.println("1. Sederhana (pengeluaran sebesar 3 juta per bulan)"
                            + "\n2. Menengah (pengeluaran sebesar 10 juta per bulan)"
                            + "\n3. Mewah (pengeluaran sebesar 20 juta per bulan)"
                            + "\n4. Atur pengeluaran secara mandiri (custom)");

                    System.out.println("");
                    while (true) {
                        System.out.print("Silahkan pilih opsi yang sesuai dengan Anda: ");
                        String opsiUser = s.next() + s.nextLine();
                        count = fun.angkachecker(opsiUser);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            if (Integer.parseInt(opsiUser) == 1) {
                                pengeluaran = 3000000;
                            } else if (Integer.parseInt(opsiUser) == 2) {
                                pengeluaran = 10000000;
                            } else if (Integer.parseInt(opsiUser) == 3) {
                                pengeluaran = 20000000;
                            } else if (Integer.parseInt(opsiUser) == 4) {
                                while (true) {
                                    System.out.print(
                                            "\nPerkiraan pengeluaran per bulan Anda di masa kini yaitu (dalam angka) yaitu Rp ");
                                    String pengeluaran_s = s.next() + s.nextLine();
                                    count = fun.angkachecker(pengeluaran_s);
                                    if (count >= 1) {
                                        System.out.println("--Input harus berupa angka--");
                                    } else {
                                        System.out.println("Apakah anda yakin? (Y / N)");
                                        String choice = s.next() + s.nextLine();
                                        if (choice.equalsIgnoreCase("Y")) {
                                            pengeluaran = Double.parseDouble(pengeluaran_s);
                                            break;
                                        } else if (choice.equalsIgnoreCase("N")) {

                                        } else {
                                            System.out.println("--Opsi dianggap N--");
                                        }
                                    }
                                }
                                break;
                            } else {
                                System.out.println("--Opsi tidak dikenal!--");
                            }
                            if (Integer.parseInt(opsiUser) >= 1 && Integer.parseInt(opsiUser) <= 3) {
                                String formatgayahidup = formatter.format(pengeluaran);
                                System.out
                                        .println("\nPengeluaran Anda di masa kini yaitu Rp " + formatgayahidup
                                                + " per bulan");
                                break;
                            }
                        }
                    }
                    arrpengeluaran.add(pengeluaran);

                    while (true) {
                        System.out.print(
                                "-------------------------------------------\nJumlah tabungan uang Anda saat ini untuk kebutuhan pensiun (ketikkan 0 jika belum tersedia) yaitu Rp ");

                        String tabung_s = s.next() + s.nextLine();
                        count = fun.angkachecker(tabung_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            tabunganUser = Long.parseLong(tabung_s);
                            arrtabunganUser.add(tabunganUser);
                            break;
                        }
                    }

                    // MENYIMPAN PENGELUARAN RAW / NO INFLASI
                    save1 = pengeluaran;
                    save2 = pengeluaran;

                    System.out.println(
                            "\n-------------------------------------------\nBerikut data diri sobat Pensia!\n-------------------------------------------");
                    String phkel = "";
                    if (kelamin_n == 1) {
                        phkel = "pria";
                    } else if (kelamin_n == 2) {
                        phkel = "wanita";
                    }
                    System.out.println("Anda adalah " + phkel + " berusia " + usia_n + " tahun");
                    System.out.println(
                            "Berencana pensiun dari usia " + usiapensi_n + " hingga " + akhirpensi_n + " tahun");
                    System.out.println("Maka masa pensiun Anda adalah " + durasipensi_n + " tahun");

                    System.out.println("-------------------------------------------");
                    while (true) {
                        System.out.print(
                                "\nDengan menambahkan jumlah persentase inflasi per tahun (dalam persen) yaitu : ");
                        String inflasi_s = s.next() + s.nextLine();
                        count = fun.angkachecker(inflasi_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            inflasi_n = Double.parseDouble(inflasi_s);
                            if (inflasi_n >= 0 && inflasi_n <= 100) {
                                inflasi.add(inflasi_n);
                                break;
                            } else {
                                System.out.println("--Nominal tidak masuk akal dan melebihi range--");
                            }
                        }
                    }

                    for (int i = 0; i < usiapensi_n - usia_n; i++) {
                        pengeluaran = pengeluaran * ((100 + inflasi_n) / 100);
                    }

                    // MENYIMPAN PENGELUARAN YANG SUDAH TERKENA INFLASI SAMPAI USIA PENSI, ini
                    // pengeluaran '60'
                    save3 = pengeluaran;
                    String formattedNumber1 = formatter.format(pengeluaran);
                    System.out.println("Maka pendapatan bulanan ideal Anda pada usia mulai pensiun " + usiapensi_n
                            + " adalah Rp " + formattedNumber1);

                    while (true) {
                        System.out.print(
                                "-------------------------------------------\n--Jika menabung secara mandiri tanpa bank, ketikkan bunga 0 %--\nDengan asumsi Anda bisa mendapatkan laju pengembalian atau bunga setiap tahunnya sebesar : ");
                        String bunga_s = s.next() + s.nextLine();
                        count = fun.angkachecker(bunga_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            bunga_n = Double.parseDouble(bunga_s);
                            if (bunga_n >= 0 && bunga_n <= 100) {
                                bunga.add(bunga_n);
                                break;
                            } else {
                                System.out.println("--Nominal tidak masuk akal dan melebihi range--");
                            }
                        }
                    }

                    // MENGHITUNG PENGELUARAN DARI 60 - 65
                    // mulai dari usiapensi + 1, soalnya ngambil save3 / usiapensi_n ke '65', lalu
                    // ditambah jadi 66 di attempt pertama
                    for (int a = (usiapensi_n + 1); a <= akhirpensi_n; a++) {
                        save3 = (save3 * ((100 + inflasi_n) / 100));
                        pengeluaran = pengeluaran + (save3); // pengeluaran dari 60 - 65 / usiapensi-akhirpensi
                    }

                    save1 = (bunga_n / 100) * (save1);// BUNGA DI TAHUN PERTAMA nya di sini

                    // MENGHITUNG BUNGA di TAHUN KEDUA SETELAH RAW DAN SETERUSNYA
                    for (int a = 1; a < usiapensi_n - usia_n; a++) {
                        save2 = (save2 * ((100 + inflasi_n) / 100));
                        save1 = save1 + (bunga_n / 100) * (save2);
                    }

                    pengeluaran = pengeluaran - save1 - tabunganUser;

                    String formattedNumber2 = formatter.format(pengeluaran);
                    System.out.println("Maka total dana yang harus anda persiapkan untuk pensiun selama "
                            + durasipensi_n + " tahun adalah Rp " + formattedNumber2);

                    bungafinal.add(pengeluaran);

                    while (true) {
                        System.out.print(
                                "-------------------------------------------\nMasukkan tahun berapa pada saat pembuatan akun ini : ");
                        String tahun_s = s.next() + s.nextLine();
                        count = fun.angkachecker(tahun_s);
                        if (count >= 1) {
                            System.out.println("--Input harus berupa angka--");
                        } else {
                            if (Integer.parseInt(tahun_s) >= 0 && Integer.parseInt(tahun_s) <= 9999) {
                                tahun_n = Integer.parseInt(tahun_s);
                                tahun.add(tahun_n);
                                break;
                            } else {
                                System.out.println("--Tahun tidak bisa melebihi 4 digit--");
                            }
                        }
                    }

                    double bulan_acc;
                    while (true) {
                        System.out.print(
                                "Masukkan bulan pada saat pembuatan akun ini (Ketikkan Januari, Februari...) : ");
                        String bulan_opsi = s.next() + s.nextLine();
                        if (bulan_opsi.equalsIgnoreCase("Januari")) {
                            bulan_acc = 12;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Februari")) {
                            bulan_acc = 11;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Maret")) {
                            bulan_acc = 10;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("April")) {
                            bulan_acc = 9;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Mei")) {
                            bulan_acc = 8;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Juni")) {
                            bulan_acc = 7;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Juli")) {
                            bulan_acc = 6;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Agustus")) {
                            bulan_acc = 5;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("September")) {
                            bulan_acc = 4;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Oktober")) {
                            bulan_acc = 3;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("November")) {
                            bulan_acc = 2;
                            break;
                        } else if (bulan_opsi.equalsIgnoreCase("Desember")) {
                            bulan_acc = 1;
                            break;
                        } else {
                            System.out.println("--Bulan tidak dikenal--");
                        }
                    }
                    bulan.add(bulan_acc);
                    double angsuran_n = (pengeluaran - tabunganUser) / ((usiapensi_n - usia_n - 1) * 12 + bulan_acc);

                    angsuran.add(angsuran_n);

                    String formattedNumber3 = formatter.format(angsuran_n);
                    System.out
                            .println("-------------------------------------------\nMaka jumlah angsuran anda yaitu Rp "
                                    + formattedNumber3 + " per bulan!");

                    countbarispembuku.add(1);

                    count_user++;
                    System.out.println("\n--Kembali ke Menu--");

                } else if (opsi.equals("2")) {
                    int tempuser = 0;
                    NumberFormat formatter = NumberFormat.getInstance(new Locale("in", "ID"));
                    formatter.setMaximumFractionDigits(2);
                    formatter.setMinimumFractionDigits(2);
                    formatter.setGroupingUsed(true);

                    if (count_user == 0) {
                        System.out.println(
                                "--Belum ada sobat Pensia yang terdaftar! Mulailah melakukan register!--\n\n--Kembali ke Menu--");
                    } else {
                        tempuser = fun.login(tempuser, username_n, password_n, username, password_acc);

                        String formattedBunga = formatter.format(bungafinal.get(tempuser));
                        String formattedRAWOut = formatter.format(arrpengeluaran.get(tempuser));
                        String formattedTabung = formatter.format(arrtabunganUser.get(tempuser));
                        String formattedAngsuran = formatter.format(angsuran.get(tempuser));

                        System.out.println("-------------------------------------------\nSelamat datang "
                                + username.get(tempuser) + " !");
                        if (kelamin.get(tempuser) == 1) {
                            System.out.println("Anda adalah seorang pria berusia " + usia.get(tempuser) + " tahun");
                        } else {
                            System.out.println("Anda adalah seorang wanita berusia" + usia.get(tempuser) + " tahun");
                        }

                        System.out.println(
                                "Usia pensiun Anda dari " + usiapensi.get(tempuser) + " hingga "
                                        + akhirpensi.get(tempuser) +
                                        " (durasi " + durasipensi.get(tempuser) + " tahun)");
                        System.out.println("Dengan inflasi per tahun sebesar " + inflasi.get(tempuser)
                                + " % dan bunga per tahun sebesar " + bunga.get(tempuser) + " %");
                        System.out.println("Maka total dana pensiun yang perlu dipersiapkan selama "
                                + durasipensi.get(tempuser) + " tahun adalah Rp "
                                + formattedBunga);
                        System.out.println(
                                "Pengeluaran mentah atau dasar (tanpa inflasi) per bulan yaitu sebesar Rp "
                                        + formattedRAWOut
                                        + "\nTabungan awal yaitu sebesar Rp " + formattedTabung);
                        System.out.println(
                                "Maka angsuran per bulan yang diperlukan untuk mencukupi dana pensiun yaitu sebesar Rp "
                                        + formattedAngsuran + " per bulan\n------------------------------------------");

                        int countISI = 0;

                        while (true) {
                            System.out.println(
                                    "\n-----------------------------------------------------------------\nTABEL PEMBUKUAN\n-----------------------------------------------------------------");
                            System.out.println("USIA I TAHUN I BULAN I ANGSURAN PER BULAN  I  PROGRES ANGSURAN  I");

                            String bulan_n = "";
                            if (bulan.get(tempuser) == 12) {
                                bulan_n = "Januari";
                            } else if (bulan.get(tempuser) == 11) {
                                bulan_n = "Februari";
                            } else if (bulan.get(tempuser) == 10) {
                                bulan_n = "Maret";
                            } else if (bulan.get(tempuser) == 9) {
                                bulan_n = "April";
                            } else if (bulan.get(tempuser) == 8) {
                                bulan_n = "Mei";
                            } else if (bulan.get(tempuser) == 7) {
                                bulan_n = "Juni";
                            } else if (bulan.get(tempuser) == 6) {
                                bulan_n = "Juli";
                            } else if (bulan.get(tempuser) == 5) {
                                bulan_n = "Agustus";
                            } else if (bulan.get(tempuser) == 4) {
                                bulan_n = "September";
                            } else if (bulan.get(tempuser) == 3) {
                                bulan_n = "Oktober";
                            } else if (bulan.get(tempuser) == 2) {
                                bulan_n = "November";
                            } else if (bulan.get(tempuser) == 1) {
                                bulan_n = "Desember";
                            }

                            for (int a = 0; a < countbarispembuku.get(tempuser); a++) {
                                int countyear = 0;
                                int countusia = 0;
                                if (a >= bulan.get(tempuser)) {
                                    countyear++;
                                    countusia++;
                                    int z = a;
                                    while (z >= (bulan.get(tempuser) + 12)) {
                                        z = z - 12;
                                        countyear++;
                                        countusia++;
                                    }
                                }

                                if (a > 0) {
                                    if (bulan_n.equals("Januari")) {
                                        bulan_n = "Februari";
                                    } else if (bulan_n.equals("Februari")) {
                                        bulan_n = "Maret";
                                    } else if (bulan_n.equals("Maret")) {
                                        bulan_n = "April";
                                    } else if (bulan_n.equals("April")) {
                                        bulan_n = "Mei";
                                    } else if (bulan_n.equals("Mei")) {
                                        bulan_n = "Juni";
                                    } else if (bulan_n.equals("Juni")) {
                                        bulan_n = "Juli";
                                    } else if (bulan_n.equals("Juli")) {
                                        bulan_n = "Agustus";
                                    } else if (bulan_n.equals("Agustus")) {
                                        bulan_n = "September";
                                    } else if (bulan_n.equals("September")) {
                                        bulan_n = "Oktober";
                                    } else if (bulan_n.equals("Oktober")) {
                                        bulan_n = "November";
                                    } else if (bulan_n.equals("November")) {
                                        bulan_n = "Desember";
                                    } else if (bulan_n.equals("Desember")) {
                                        bulan_n = "Januari";
                                    }
                                }

                                if (a == 0) {
                                    angsuran_hutang2D[tempuser][a] = angsuran.get(tempuser);
                                } else {
                                    angsuran_hutang2D[tempuser][a] = (angsuran_hutang2D[tempuser][a - 1]
                                            + angsuran.get(tempuser)) - angsuran_user2D[tempuser][a - 1];
                                }

                                if (angsuran_user2D[tempuser][a] == null) {
                                    angsuran_user2D[tempuser][a] = angsuran.get(tempuser); // hanya placeholder
                                }

                                String formattedHutang = formatter.format(angsuran_hutang2D[tempuser][a]);
                                String formattedUser = formatter.format(angsuran_user2D[tempuser][a]);
                                if (a == countbarispembuku.get(tempuser) - 1) {
                                    System.out.println(" " + (usia.get(tempuser) + countusia) + "  I  "
                                            + (tahun.get(tempuser) + countyear)
                                            + " I " + bulan_n + " I  Rp " + formattedHutang
                                            + "  I  Rp ...KOSONG...  I");
                                } else {
                                    System.out.println(" " + (usia.get(tempuser) + countusia) + "  I  "
                                            + (tahun.get(tempuser) + countyear)
                                            + " I " + bulan_n + " I  Rp " + formattedHutang + "  I  Rp "
                                            + formattedUser + "  I");
                                }
                            }

                            int subISI = 0;
                            while (true) {
                                subISI = 0;
                                if (countISI == 0) {
                                    System.out.println(
                                            "-----------------------------------------------------------------\nApakah anda ingin mengisi progres angsuran tabel? (Y / N)");
                                } else {
                                    System.out.println(
                                            "-----------------------------------------------------------------\nApakah anda ingin mengisi progres angsuran tabel sekali lagi? (Y / N)");
                                }
                                String choice = s.next() + s.nextLine();
                                if (choice.equalsIgnoreCase("Y")) {
                                    break;
                                } else if (choice.equalsIgnoreCase("N")) {
                                    System.out.println("\n--Kembali ke menu--");
                                    subISI++;
                                    break;
                                } else {
                                    System.out.println("--Opsi masih belum pasti--");
                                }

                            }

                            if (subISI > 0) {
                                break;
                            }

                            while (true) {
                                System.out.print(
                                        "------------------------------------------\nMengisi progres tabungan user yang kosong : Rp ");
                                String angsuranuser_n = s.next() + s.nextLine();
                                int count = fun.angkachecker(angsuranuser_n);
                                if (count >= 1) {
                                    System.out.println("--Input harus berupa angka--");
                                } else {
                                    System.out.println("Apakah anda yakin? (Y / N)");
                                    String choice = s.next() + s.nextLine();
                                    if (choice.equalsIgnoreCase("Y")) {
                                        angsuran_user2D[tempuser][countbarispembuku.get(tempuser) - 1] = Double
                                                .parseDouble(angsuranuser_n);
                                        int countBRUH = countbarispembuku.get(tempuser) + 1;
                                        countbarispembuku.set(tempuser, countBRUH);
                                        countISI++;
                                        break;
                                    } else if (choice.equalsIgnoreCase("N")) {

                                    } else {
                                        System.out.println("--Opsi dianggap N--");
                                    }
                                }
                            }
                        }
                    }

                } else if (opsi.equals("3")) {
                    int tempuser = 0;

                    if (count_user == 0) {
                        System.out.println(
                                "--Belum ada user yang terdaftar! Mulailah melakukan register!--\n\n--Kembali ke Menu--");
                    } else {
                        tempuser = fun.login(tempuser, username_n, password_n, username, password_acc);
                        while (true) {
                            System.out.println(
                                    "-------------------------------------------\nBerhasil Log in\n-------------------------------------------");
                            System.out.print(
                                    "Apakah anda yakin ingin menghapus akun anda?\nSeluruh riwayat dan data pembukuan anda akan dihapuskan! (Y / N) : ");
                            String opsidelete = s.next() + s.nextLine();
                            if (opsidelete.equalsIgnoreCase("Y")) {
                                Random rand = new Random();
                                int dead_user = rand.nextInt(9999);
                                int dead_password = rand.nextInt(9999);
                                username.set(tempuser, Integer.toString(dead_user));
                                password_acc.set(tempuser, Integer.toString(dead_password));

                                System.out.println("--Akun berhasil dihapuskan--\n\n--Kembali ke menu--");
                                count_user--;
                                break;
                            } else if (opsidelete.equalsIgnoreCase("N")) {
                                System.out.println("--Perintah dimengerti--\n\n--Kembali ke menu--");
                                break;
                            } else {
                                System.out.println("--Opsi tidak dikenal!--");
                            }
                        }
                    }

                } else if (opsi.equals("0")) {
                    System.out.println(
                            "------------------------------------------\nTerima kasih dan sampai jumpa! \n~Siap siaga mempersiapkan masa pensiun yang ceria~");
                    break;

                } else {
                    System.out.println("--Opsi tidak dikenal--");
                }
            }
        }
    }

    public int login(int tempuser, String username_n, String password_n, ArrayList<String> username,
            ArrayList<String> password_acc) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int temp1 = 0, temp2 = 0;
            System.out.print("\n-------------------------------------------\nUsername: ");
            username_n = s.next();
            while (true) {
                temp1 = 0;
                System.out.print("Password: ");
                password_n = s.next();

                for (int a = 0; a < username.size(); a++) {
                    if ((username.get(a)).equals(username_n)) {
                        if ((password_acc.get(a)).equals(password_n)) {
                            tempuser = a;
                            break;
                        } else {
                            System.out.println(
                                    "Password Anda salah, silahkan coba lagi!\n-------------------------------------------");
                            temp1++;
                            break;
                        }
                    } else {

                        temp2++;

                    }
                }
                if (temp1 == 1) {

                } else if (temp2 == username.size()) {
                    break;
                } else {
                    break;
                }
            }
            if (temp2 == username.size()) {
                System.out
                        .println(
                                "Username Anda salah atau tidak terdaftar, silahkan coba lagi!\n------------------------------------------- ");
            } else {
                break;
            }
        }
        return tempuser;
    }

    public int validcheck(int count1, int count2, char[] passpisah, String input) {
        if (count1 + count2 == passpisah.length) {
            if (count1 > 0 && count2 > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    public int angkachecker(String input) {
        int count = 0;
        String alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] listalfa = alfa.toCharArray();
        char[] pisahinput = input.toCharArray();
        char[] specialCharacters = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '{', '}',
                '[', ']', '|', '\\', ':', ';', '"', '<', '>', ',', '.', '?' };
        for (int a = 0; a < pisahinput.length; a++) {
            for (int b = 0; b < listalfa.length; b++) {
                if (pisahinput[a] == listalfa[b]) {
                    count++;
                    break;
                } else {

                }
            }
        }
        for (int a = 0; a < pisahinput.length; a++) {
            for (int b = 0; b < specialCharacters.length; b++) {
                if (pisahinput[a] == specialCharacters[b]) {
                    count++;
                    break;
                } else {

                }
            }
        }
        return count;
    }
}
