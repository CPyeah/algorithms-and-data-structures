package demo.data.jpa;

import demo.core.user.User;
import demo.core.user.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProxyUserRepository implements UserRepository {

	@Autowired
	private UserJpaRepository jpaRepository;

	public User save(User newUser) {
		UserJpaEntity newEntity = new UserJpaEntity(newUser);
		UserJpaEntity savedEntity = jpaRepository.save(newEntity);
		User savedUser = savedEntity.toUser();
		return savedUser;
	}

	public List<User> all() {
		List<UserJpaEntity> entities = jpaRepository.findAll();
		List<User> users = new ArrayList<User>(entities.size());
		for (UserJpaEntity entity : entities) {
			User user = entity.toUser();
			users.add(user);
		}
		return users;
	}


}
