-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28 Des 2017 pada 09.04
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `napi`
--

CREATE TABLE `napi` (
  `id` bigint(20) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jen_kel` varchar(100) NOT NULL,
  `keluar` varchar(100) NOT NULL,
  `lama` varchar(100) NOT NULL,
  `masuk` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `faktor_id` bigint(20) DEFAULT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `napi`
--

INSERT INTO `napi` (`id`, `alamat`, `jen_kel`, `keluar`, `lama`, `masuk`, `nama`, `faktor_id`, `image`) VALUES
(8, 'surabaya jaya', 'Laki-laki', '2017-07-22', '10 tahun', '2017-07-14', 'abid', 6, 'ka.jpg'),
(10, 'Kediri', 'Laki-laki', '2017-07-29', '10 tahun', '2017-07-14', 'Nia', 8, 'ka.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `napi`
--
ALTER TABLE `napi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK27lq05q6eibyyqhirmj21hsp3` (`faktor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `napi`
--
ALTER TABLE `napi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `napi`
--
ALTER TABLE `napi`
  ADD CONSTRAINT `FK27lq05q6eibyyqhirmj21hsp3` FOREIGN KEY (`faktor_id`) REFERENCES `faktor` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
