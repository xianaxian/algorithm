#查询每个科目前3名的数据
SELECT t1.*
FROM test AS t1
WHERE 3>(
  SELECT COUNT(DISTINCT t2.score)
	FROM test AS t2
	WHERE t1.score<t2.score AND t1.course_id =t2.course_id
);

SELECT *
FROM test AS  t1 join test AS t2 ON t1.score<=t2.score AND t1.course_id=t2.course_id
ORDER BY t1.id;
#比那一条记录同科目高的高的数据，ORDER BY 是为了查看方便

SELECT t1.*
FROM test AS  t1 join test AS t2 ON t1.score<=t2.score AND t1.course_id=t2.course_id
GROUP BY t1.id
HAVING COUNT(DISTINCT t2.score)<=3
ORDER  BY t1.course_id ASC,t1.score DESC;
#按照成绩的id进行分组，有比这个成绩值大的记录，对记录的 score DISTINCT以后，如果小于等于3的就是前3
#以下是参考数据库
-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course_id` int(10) UNSIGNED NOT NULL,
  `course_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `score` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 2005001, '张三', 1, '数学', 69);
INSERT INTO `test` VALUES (2, 2005002, '李四', 1, '数学', 81);
INSERT INTO `test` VALUES (3, 2005005, '王五', 1, '数学', 23);
INSERT INTO `test` VALUES (4, 2005001, '张三', 2, '语文', 69);
INSERT INTO `test` VALUES (5, 2005002, '李四', 2, '语文', 81);
INSERT INTO `test` VALUES (6, 2005005, '王五', 2, '语文', 88);
INSERT INTO `test` VALUES (7, 2005006, '赵六', 2, '语文', 69);
INSERT INTO `test` VALUES (8, 2005006, '赵六', 1, '数学', 89);
INSERT INTO `test` VALUES (9, 2005007, '郑七', 2, '语文', 100);

SET FOREIGN_KEY_CHECKS = 1;

