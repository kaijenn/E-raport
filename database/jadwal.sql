/*
 Navicat Premium Data Transfer

 Source Server         : yoga
 Source Server Type    : MySQL
 Source Server Version : 100428 (10.4.28-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : jadwal

 Target Server Type    : MySQL
 Target Server Version : 100428 (10.4.28-MariaDB)
 File Encoding         : 65001

 Date: 25/09/2024 22:02:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blok
-- ----------------------------
DROP TABLE IF EXISTS `blok`;
CREATE TABLE `blok`  (
  `id_blok` int NOT NULL AUTO_INCREMENT,
  `nama_blok` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_blok`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blok
-- ----------------------------
INSERT INTO `blok` VALUES (1, 'blok 1');
INSERT INTO `blok` VALUES (2, 'blok 2');
INSERT INTO `blok` VALUES (3, 'blok 3');
INSERT INTO `blok` VALUES (4, 'blok 4');
INSERT INTO `blok` VALUES (5, 'blok 5');
INSERT INTO `blok` VALUES (6, 'blok 6');
INSERT INTO `blok` VALUES (7, 'blok 7');
INSERT INTO `blok` VALUES (8, 'blok 8');

-- ----------------------------
-- Table structure for guru
-- ----------------------------
DROP TABLE IF EXISTS `guru`;
CREATE TABLE `guru`  (
  `id_guru` int NOT NULL AUTO_INCREMENT,
  `nama_guru` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nama_mapel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_guru`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of guru
-- ----------------------------
INSERT INTO `guru` VALUES (1, 'ELVAN', 'MTK');
INSERT INTO `guru` VALUES (2, 'YOGA', 'B INDO');
INSERT INTO `guru` VALUES (3, 'LEO', 'ENGLISH');
INSERT INTO `guru` VALUES (4, 'ERWIN', 'IPS');
INSERT INTO `guru` VALUES (5, 'ROBIN', 'PJOK');
INSERT INTO `guru` VALUES (6, 'DARREN', 'CONVERS');
INSERT INTO `guru` VALUES (7, 'YURO', 'SEJARAH');
INSERT INTO `guru` VALUES (8, 'TINARDO', 'SENI BUDAYA');
INSERT INTO `guru` VALUES (9, 'CAHYA', 'IPS');
INSERT INTO `guru` VALUES (10, 'ASIM', 'MANDARIN');
INSERT INTO `guru` VALUES (11, 'ASAI', 'TIK');
INSERT INTO `guru` VALUES (12, 'EPAN', 'KIMIA');
INSERT INTO `guru` VALUES (13, 'EPIN', 'FISIKA');
INSERT INTO `guru` VALUES (14, 'ALVIN', 'BIOLOGI');
INSERT INTO `guru` VALUES (32, 'ttt', '0sadsad');

-- ----------------------------
-- Table structure for istirahat
-- ----------------------------
DROP TABLE IF EXISTS `istirahat`;
CREATE TABLE `istirahat`  (
  `id_istirahat` int NOT NULL AUTO_INCREMENT,
  `istirahat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_istirahat`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of istirahat
-- ----------------------------
INSERT INTO `istirahat` VALUES (1, 'ISTIRAHAT');

-- ----------------------------
-- Table structure for jadwal
-- ----------------------------
DROP TABLE IF EXISTS `jadwal`;
CREATE TABLE `jadwal`  (
  `id_jadwal` int NOT NULL AUTO_INCREMENT,
  `jam_mulai` time NULL DEFAULT NULL,
  `jam_selesai` time NULL DEFAULT NULL,
  `sesi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_guru` int NULL DEFAULT NULL,
  `id_kelas` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_blok` int NULL DEFAULT NULL,
  `id_tahun_ajaran` int NULL DEFAULT NULL,
  `id_mapel` int NULL DEFAULT NULL,
  PRIMARY KEY (`id_jadwal`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jadwal
-- ----------------------------
INSERT INTO `jadwal` VALUES (68, '19:28:00', '19:28:00', '1', 1, '6', 8, 1, NULL);
INSERT INTO `jadwal` VALUES (69, '19:59:00', '19:59:00', '2', 1, '1', 1, 1, 1);
INSERT INTO `jadwal` VALUES (70, '20:05:00', '20:05:00', '1', 1, '1', 1, 1, 1);

-- ----------------------------
-- Table structure for kelas
-- ----------------------------
DROP TABLE IF EXISTS `kelas`;
CREATE TABLE `kelas`  (
  `id_kelas` int NOT NULL AUTO_INCREMENT,
  `nama_kelas` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_kelas`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kelas
-- ----------------------------
INSERT INTO `kelas` VALUES (1, 'IX');
INSERT INTO `kelas` VALUES (2, 'VII');
INSERT INTO `kelas` VALUES (3, 'VIII');
INSERT INTO `kelas` VALUES (4, 'X');
INSERT INTO `kelas` VALUES (5, 'XI');
INSERT INTO `kelas` VALUES (6, 'XII');

-- ----------------------------
-- Table structure for mapel
-- ----------------------------
DROP TABLE IF EXISTS `mapel`;
CREATE TABLE `mapel`  (
  `id_mapel` int NOT NULL AUTO_INCREMENT,
  `nama_mapel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_mapel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mapel
-- ----------------------------
INSERT INTO `mapel` VALUES (1, 'MTK ');
INSERT INTO `mapel` VALUES (2, 'Bahasa Indonesia');
INSERT INTO `mapel` VALUES (3, 'PJOK');
INSERT INTO `mapel` VALUES (4, 'Pemrograman Web');
INSERT INTO `mapel` VALUES (5, 'Basis Data');

-- ----------------------------
-- Table structure for penilaian
-- ----------------------------
DROP TABLE IF EXISTS `penilaian`;
CREATE TABLE `penilaian`  (
  `id_penilaian` int NOT NULL AUTO_INCREMENT,
  `id_siswa` int NULL DEFAULT NULL,
  `id_blok` int NULL DEFAULT NULL,
  `id_mapel` int NULL DEFAULT NULL,
  `nilai_tugas` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nilai_midblok` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nilai_finalblok` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total_nilai` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_semester` int NULL DEFAULT NULL,
  `id_tahun_ajaran` int NULL DEFAULT NULL,
  `id_user` int NULL DEFAULT NULL,
  `predikat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_penilaian`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of penilaian
-- ----------------------------
INSERT INTO `penilaian` VALUES (7, 1, 1, 1, '12', '80', '80', '172.0', 1, 1, NULL, 'D');
INSERT INTO `penilaian` VALUES (8, 1, 1, 1, '1', '11', '111', '123.0', 1, 1, NULL, 'D');
INSERT INTO `penilaian` VALUES (9, 1, 1, 1, '1', '1', '1', '3.0', 1, 1, NULL, 'D');
INSERT INTO `penilaian` VALUES (10, 1, 1, 1, '2.0', '3.0', '7.0', '12.0', 1, 1, NULL, 'D');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester`  (
  `id_semester` int NOT NULL AUTO_INCREMENT,
  `semester` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_semester`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of semester
-- ----------------------------
INSERT INTO `semester` VALUES (1, 'Semester 1');
INSERT INTO `semester` VALUES (2, 'Semester 2');

-- ----------------------------
-- Table structure for siswa
-- ----------------------------
DROP TABLE IF EXISTS `siswa`;
CREATE TABLE `siswa`  (
  `id_siswa` int NOT NULL AUTO_INCREMENT,
  `nama_siswa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nis` int NULL DEFAULT NULL,
  `nama_jurusan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_kelas` int NULL DEFAULT NULL,
  PRIMARY KEY (`id_siswa`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of siswa
-- ----------------------------
INSERT INTO `siswa` VALUES (1, 'yoga', 22161020, 'Rpl', 1);

-- ----------------------------
-- Table structure for tahun_ajaran
-- ----------------------------
DROP TABLE IF EXISTS `tahun_ajaran`;
CREATE TABLE `tahun_ajaran`  (
  `id_tahun_ajaran` int NOT NULL AUTO_INCREMENT,
  `tahun_ajaran` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_tahun_ajaran`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tahun_ajaran
-- ----------------------------
INSERT INTO `tahun_ajaran` VALUES (1, '2024/2025');
INSERT INTO `tahun_ajaran` VALUES (2, '2025/2026');
INSERT INTO `tahun_ajaran` VALUES (3, '3000/5000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` enum('Waka','Guru','Siswa') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `foto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_activity` time NULL DEFAULT NULL,
  PRIMARY KEY (`id_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'waka', '1', 'Waka', '1710919939_7ee3334998466c4c81ca.jpg', '13:17:28');
INSERT INTO `user` VALUES (2, 'guru', '2', 'Guru', NULL, NULL);
INSERT INTO `user` VALUES (3, 'siswa', '3', 'Siswa', NULL, NULL);

-- ----------------------------
-- Table structure for waka
-- ----------------------------
DROP TABLE IF EXISTS `waka`;
CREATE TABLE `waka`  (
  `id_waka` int NOT NULL AUTO_INCREMENT,
  `nama_waka` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nis` int NULL DEFAULT NULL,
  PRIMARY KEY (`id_waka`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of waka
-- ----------------------------
INSERT INTO `waka` VALUES (1, 'Yoga', 22161050);

SET FOREIGN_KEY_CHECKS = 1;
