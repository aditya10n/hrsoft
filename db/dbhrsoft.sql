-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05 Nov 2017 pada 00.53
-- Versi Server: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrsoft`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `interview`
--

CREATE TABLE `interview` (
  `id_interview` int(11) NOT NULL,
  `id_kandidat` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `jam_mulai` time DEFAULT NULL,
  `jam_selesai` time DEFAULT NULL,
  `dengan` varchar(255) DEFAULT NULL,
  `lokasi` text,
  `deskripsi` text,
  `hasil` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kandidat`
--

CREATE TABLE `kandidat` (
  `id_kandidat` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `id_pekerjaan` int(11) NOT NULL,
  `status` varchar(25) NOT NULL,
  `education` text,
  `experience` text,
  `grup` enum('APPLICANT','INTERVIEW','HIRED','DROP') NOT NULL,
  `nama` varchar(255) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kandidat`
--

INSERT INTO `kandidat` (`id_kandidat`, `username`, `id_pekerjaan`, `status`, `education`, `experience`, `grup`, `nama`, `phone`, `email`, `alamat`) VALUES
(1, 'admin', 1, 'not Ready', NULL, NULL, 'APPLICANT', 'Aditya Nugraha', NULL, 'aditya10nugraha@gmail.com', NULL),
(2, 'admin', 2, 'not Ready', NULL, NULL, 'INTERVIEW', 'Dini Badriani', '085695359496', 'dinibadrianis@gmail.com', 'CIMAHI');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pekerjaan`
--

CREATE TABLE `pekerjaan` (
  `id_pekerjaan` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `lokasi` text NOT NULL,
  `deskripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pekerjaan`
--

INSERT INTO `pekerjaan` (`id_pekerjaan`, `nama`, `lokasi`, `deskripsi`) VALUES
(1, 'Junior Programmer', ' ', ' '),
(2, 'Senior Programmer', '', ''),
(4, 'Office Boy', 'Jalan Kopo No.24', 'Lulusan SMA/SMK\nUmur Maks 30 Tahun'),
(5, 'Accountant Finance', 'Istana Pasteur Regency Cicendo', 'Fresh Gradyate are welcome\nRequired Skill(s) : Microsoft Office, Microsoft Project, Administration, Accountant, Finance, Tax');

-- --------------------------------------------------------

--
-- Struktur dari tabel `staff`
--

CREATE TABLE `staff` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `staff`
--

INSERT INTO `staff` (`username`, `password`, `nama`, `phone`) VALUES
('admin', 'admin', 'admin', '081214788641');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`id_interview`),
  ADD KEY `id_kandidat` (`id_kandidat`);

--
-- Indexes for table `kandidat`
--
ALTER TABLE `kandidat`
  ADD PRIMARY KEY (`id_kandidat`),
  ADD KEY `id_pekerjaan` (`id_pekerjaan`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `pekerjaan`
--
ALTER TABLE `pekerjaan`
  ADD PRIMARY KEY (`id_pekerjaan`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interview`
--
ALTER TABLE `interview`
  MODIFY `id_interview` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `kandidat`
--
ALTER TABLE `kandidat`
  MODIFY `id_kandidat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pekerjaan`
--
ALTER TABLE `pekerjaan`
  MODIFY `id_pekerjaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `interview_ibfk_1` FOREIGN KEY (`id_kandidat`) REFERENCES `kandidat` (`id_kandidat`);

--
-- Ketidakleluasaan untuk tabel `kandidat`
--
ALTER TABLE `kandidat`
  ADD CONSTRAINT `kandidat_ibfk_2` FOREIGN KEY (`id_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`),
  ADD CONSTRAINT `kandidat_ibfk_3` FOREIGN KEY (`username`) REFERENCES `staff` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
