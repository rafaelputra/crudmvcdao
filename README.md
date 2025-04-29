### Atur Primary Key dan Set Auto Increment
Akses database dari mysql kemudian ketik perintah 

`ALTER TABLE tblmahasiswa MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY (id);`

### Ubah Value pada Kolom Jk
Akses database dari mysql kemudian ketik perintah

`UPDATE tblmahasiswa SET jk='L' WHERE id=1`

### Catatan
- Saat melakukan penambahan data, kosongkan pada bagian ID.
- Saat melakukan penghapusan data, cukup isikan ID yang ingin dihapus.
