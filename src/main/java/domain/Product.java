package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal price;
	
	private LocalDate expirationDate;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;

}
