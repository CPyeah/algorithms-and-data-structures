package excel.model;

public enum Hospital {


	南京鼓楼医院(1),
	江苏省人民医院(2),
	南医二附院(3),
	南京市妇幼保健院(4),
	南京市第一医院(5),
	南京市第二医院(6),
	南京市江宁医院(7),
	南京同仁医院(8),
	南京明基医院(9),
	南京江北人民医院(10),
	东南大学附属中大医院(11),
	无锡市第四人民医院(12),
	无锡市人民医院(13),
	无锡市第二人民医院(14),
	无锡市妇幼保健院(15),
	江阴市人民医院(16),
	宜兴市人民医院(17),
	南通市妇幼保健院(18),
	南通大学附属医院(19),
	南通市第一人民医院(20),
	南通市第三人民医院(21),
	南通肿瘤医院(22),
	南通瑞慈医院(23),
	海安县人民医院(24),
	启东市人民医院(25),
	淮安市妇幼保健院(26),
	淮安市第一人民医院(27),
	淮安市第二人民医院(28),
	淮安市第四人民医院(29),
	淮安市肿瘤医院(30),
	徐州市妇幼保健院(31),
	徐州医学院附属医院(32),
	徐州市第一人民医院(33),
	徐州市肿瘤医院(34),
	徐州矿务集团总医院(35),
	徐州市中心医院(36),
	邳州市人民医院(37),
	新沂市人民医院(38),
	苏州大学附属第一医院(39),
	苏州大学附属第二医院(40),
	苏州市立医院(41),
	常熟市第一人民医院(42),
	苏州九龙医院(43),
	苏州市第五人民(44),
	昆山市第一人民医院(45),
	吴江市第一人民医院(46),
	张家港市第一人民医院(47),
	常熟市第二人民医院(48),
	太仓市第一人民医院(49),
	江苏盛泽医院(50),
	常州市第一人民医院(51),
	常州市第二人民医院(52),
	常州市第三人民医院(53),
	常州市妇幼保健院(54),
	常州市肿瘤医院(55),
	常州市武进人民医院(56),
	连云港市第一人民医院(57),
	连云港市第二人民医院(58),
	连云港市妇幼保健院(59),
	连云港市东方医院(60),
	盐城市第一人民医院(61),
	盐城市第二人民医院(62),
	盐城市第三人民医院(63),
	盐城市妇幼保健院(64),
	东台市人民医院(65),
	建湖县人民医院(66),
	苏北人民医院(67),
	扬州大学附属医院(68),
	扬州市妇幼保健院(69),
	高邮市人民医院(70),
	江苏大学附属医院(71),
	镇江市妇幼保健院(72),
	镇江市第一人民医院(73),
	丹阳市人民医院(74),
	泰州市人民医院(75),
	泰州市第二人民医院(76),
	泰兴市人民医院(77),
	兴化市人民医院(78),
	靖江市人民医院(79),
	宿迁市人民医院(80),
	沭阳县人民医院(81),
	高淳县人民医院(82),
	宿迁市第一人民医院(83),
	不知道_需要手动看(999),

	;

	int order;

	float similar;

	Hospital(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public float getSimilar() {
		return similar;
	}

	public void setSimilar(float similar) {
		this.similar = similar;
	}

	public String getSimpleName() {
		String name = this.name();
		if (name.contains("医院")) {
			return name.replace("医院", "");
		}
		if (name.contains("保健院")) {
			return name.replace("保健院", "");
		}
		return name;
	}

	public static Hospital findByName(String name) {
		for (Hospital hospital : Hospital.values()) {
			String simpleName = hospital.getSimpleName();
			if (name.contains(simpleName)) {
				return hospital;
			}
		}
		return 不知道_需要手动看;
	}

	public static void main(String[] args) {
		Hospital byName = Hospital.findByName("镇江市妇幼保健院.xls");
		System.out.println(byName);
	}
}
