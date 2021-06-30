Коллекции, компараторы, полиморфизм, DTO, Supplier*, Comparator:

Задание 1:		- dto.Person.java
			- dto.Animal.java

Задание 2:		- comparators.AnimalAgeComparator.java
			- comparators.AnimalAgeNickComparator.java
			(наследует и дополняет AnimalAgeComparator)
			- comparators.AnimalNickComparator.java
			(позволяет применить .thenComparing())
			- comparators.PersonPassComparator.java
			- comparators.PersonPassNickComparator.java
			(наследует и дополняет PersonPassComparator)
			- comparators.PersonNickComparator.java
			(позволяет применить .thenComparing())

Задание 3.1:		- utils.CollectionsRandomFill.java
			(позволяет заполнить коллекцию нужным количеством объектов)
			- suppliers.GetAnimalRandom.java
			- suppliers.GetPersonRandom.java

Задание 3.2,		- test.CollectionsRandomFillAndSortTest.java
Задание 3.3:		- utils.CollectionsMySortMethod.java
			(содержит свой метод сортировки)
			- test.CollectionsRandomFillAndSortTest.java
			(проверка сортировки)

Задание 3.4:		- utils.CollectionOperationsTime.java
			(содержит сами методы итерации, удаления и замера времени)
			- utils.CollectionOperationsTimeWithSupplier.java
			(доработан для применения Supplier)
			- test.CollectionsFillAndIterateAndClearTest.java
			(проверка и "распечатка" результатов)