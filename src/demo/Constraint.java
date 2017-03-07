package demo;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Lists;

/**
 * 解决guava-18.0.jar不能使用
 * com.google.common.collect.Constraints、
 * com.google.common.collect.Constraint 的问题。
 * @author liguodong
 * @param <E>
 */
interface Constraint<E>{
    //public String checkElement(String element);
    E checkElement(E element);
}

class Constraints<E>{
    public static <E> Set<E> constrainedSet(
              Set<E> set, Constraint<? super E> constraint) {
            return new ConstrainedSet<E>(set, constraint);
          }
     private static <E> Collection<E> checkElements(
              Collection<E> elements, Constraint<? super E> constraint) {
            Collection<E> copy = Lists.newArrayList(elements);
            for (E element : copy) {
              constraint.checkElement(element);
            }
            return copy;
          }
     /** @see Constraints#constrainedSet */
     static class ConstrainedSet<E> extends ForwardingSet<E> {
       private final Set<E> delegate;
       private final Constraint<? super E> constraint;

       public ConstrainedSet(Set<E> delegate, Constraint<? super E> constraint) {
         this.delegate = checkNotNull(delegate);
         this.constraint = checkNotNull(constraint);
       }
       @Override protected Set<E> delegate() {
         return delegate;
       }
       @Override public boolean add(E element) {
         constraint.checkElement(element);
         return delegate.add(element);
       }
       @Override public boolean addAll(Collection<? extends E> elements) {
         return delegate.addAll(checkElements(elements, constraint));
       }
     }
}