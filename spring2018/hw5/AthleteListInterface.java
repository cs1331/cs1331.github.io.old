/**
 * Interface for an AthleteList!
 *
 * @author CS1331 TAs
 * @version 13.3.1
 */
public interface AthleteListInterface<T extends Athlete> {

    /**
     * Initial capacity of the AthleteList. Use this constant, not a magic
     * number!
     */
    int INITIAL_CAPACITY = 10;

    /**
     * Adds the specified element t to the BACK of the AthleteList.
     * If the AthleteList is full, it should be resized to twice its
     * current capacity. Note that if the AthleteList needs to be
     * resized, you should resize it and then carry on the add operation
     * as normal.
     * @throws IllegalArgumentException if the element to be added is null
     * @param T Element to be added to the AthleteList
     */
    void add(Athlete t);

    /**
     * Removes the element at the specified index, and returns it.
     * If the element isn't in the AthleteList, return null.
     * You should shift every element to the right of the removed
     * element one spot to the left, so that all the null elements are
     * in the back of the array. For example, suppose there's a list with
     * [1,2,3,4,5]. If we remove the element 2, we should have [1,3,4,5]
     * afterwards. If we then remove 4, the list should look like [1,3,5].
     * list.size() would now return 3. The lists capacity would not change
     * though.
     * @throws IndexOutOfBoundsException if the index is less than zero or is
     * greater than or equal to the number of elements in the AthleteList.
     * @param int index Index of the element to be removed.
     */
    Athlete remove(int index);

    /**
     * Returns the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is less than zero or
     * greater than or equal to the number of elements in the AthleteList.
     * @param int index Index of the element to be returned.
     */
    Athlete get(int index);

    /**
     * Removes all elements from the AthleteList, and resets it back
     * to its original capacity. Size should be zero after this happens.
     */
    void clear();

    /**
     * Returns the number of elements currently in the AthleteList
     * @return The number of elements in the AthleteList
     */
    int size();

    /**
     * Returns whether this AthleteList is empty or not.
     * @return true if this AthleteList contains elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Prescribes training for the Athlete at the given
     * index via their train() method.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @param int index Index of the Athlete to be trained.
     */
    void train(int index);

    /**
     * Prescribes rest for the Athlete at the given index via their rest()
     * method.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @param int index Index of the athlete to be rested.
     */
    void rest(int index);

    /**
     * Returns the ENTIRE backing array used in your implementation of
     * AthleteList.
     * @return Your backing array.
     */
    Athlete[] asArray();





}
