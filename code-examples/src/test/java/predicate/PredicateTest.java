package predicate;

import domain.common.User;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class PredicateTest extends TestCase {

	private User bob;

	private User mary;

	private User sam;

	private User beth;

	private Collection<User> userCollection;

	public void setUp() {
		userCollection = new ArrayList<User>();
		bob = new User("Bob", false);
		mary = new User("Mary", false);
		sam = new User("Sam", false);
		beth = new User("Beth", false);
	}

	public void testFilter2ValidUsersIterator() {
		mary.setAuthorized(true);
		sam.setAuthorized(true);
		addUsers();
		CollectionUtility.filter(userCollection.iterator(),
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertTrue(userCollection.contains(mary));
		assertTrue(userCollection.contains(sam));
		assertEquals(2, userCollection.size());

	}

	public void testFilterNoValidUsersIterator() {
		addUsers();
		CollectionUtility.filter(userCollection.iterator(),
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertEquals(0, userCollection.size());

	}

	public void testFilter1ValidUsersIterator() {
		sam.setAuthorized(true);
		addUsers();
		CollectionUtility.filter(userCollection.iterator(),
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertEquals(1, userCollection.size());
		assertTrue(userCollection.contains(sam));
	}

	public void testFilter2ValidUsersCollection() {
		mary.setAuthorized(true);
		sam.setAuthorized(true);
		addUsers();
		Collection<User> users = CollectionUtility.filter(userCollection,
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertTrue(users.contains(mary));
		assertTrue(users.contains(sam));
		assertEquals(2, users.size());

	}

	public void testFilterNoValidUsersCollection() {
		addUsers();
		Collection<User> users = CollectionUtility.filter(userCollection,
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertEquals(0, users.size());

	}

	public void testFilter1ValidUsersCollection() {
		sam.setAuthorized(true);
		addUsers();
		Collection<User> users = CollectionUtility.filter(userCollection,
				new Predicate<User>() {
					public boolean apply(User user) {
						return user.isAuthorized();
					}
				});
		assertEquals(1, users.size());
		assertTrue(users.contains(sam));
	}

	public void testEliminateDuplicates() {
		addUsers();
		userCollection.add(bob);
		userCollection.add(sam);
		assertEquals(6, userCollection.size());
		Collection<User> users = CollectionUtility
				.removeDuplicates(userCollection);
		assertEquals(4, users.size());
		assertTrue(users.contains(sam));
	}

	public void testFindMatch() {
		addUsers();
		MatchPredicate<User> predicate = new MatchPredicate<User>(new User(
				"Mary", false));

		User user = CollectionUtility.find(userCollection, predicate);
		assertEquals("Mary", user.getName());

	}

	private void addUsers() {
		userCollection.add(bob);
		userCollection.add(mary);
		userCollection.add(sam);
		userCollection.add(beth);
	}

}
