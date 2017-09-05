package id.ac.tazkia.dosen.entity;

import id.ac.tazkia.dosen.constant.StatusDokumenPengajuan;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_pengajuan_document", uniqueConstraints={
    @UniqueConstraint(columnNames = {"id_pengajuan_dosen", "id_jenis_dokumen"})
})
public class PengajuanDosenDokumen {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pengajuan_dosen")
    PengajuanDosen pengajuanDosen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_jenis_dokumen")
    JenisPengajuanDokumen jenisPengajuanDokumen;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusDokumenPengajuan statusDokumen;

    @NotNull
    @NotEmpty
    @Column
    String filename;


}