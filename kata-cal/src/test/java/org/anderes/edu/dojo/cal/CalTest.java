package org.anderes.edu.dojo.cal;

import static org.mockito.Mockito.*;
import static java.util.Calendar.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalTest {
  
    @Mock
    private OutputStream mockOutputStream;
    
    @Test
    public void shouldBeFebruaryUsa() throws IOException {
        final Cal cal = new Cal(februaryUsa(2014));
        cal.printTo(mockOutputStream);
        
        final InOrder inOrder = inOrder(mockOutputStream);
        inOrder.verify(mockOutputStream).write("    Februar 2014".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("So Mo Di Mi Do Fr Sa".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("                   1".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write(" 2  3  4  5  6  7  8".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write(" 9 10 11 12 13 14 15".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("16 17 18 19 20 21 22".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("23 24 25 26 27 28   ".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verifyNoMoreInteractions();
        
        cal.printTo(System.out);
    }
    
    @Test
    public void shouldBeFebruaryEu() throws IOException {
        final Cal cal = new Cal(februaryEu(2014));
        cal.printTo(mockOutputStream);
        
        final InOrder inOrder = inOrder(mockOutputStream);
        inOrder.verify(mockOutputStream).write("    Februar 2014".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("Mo Di Mi Do Fr Sa So".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("                1  2".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write(" 3  4  5  6  7  8  9".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("10 11 12 13 14 15 16".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("17 18 19 20 21 22 23".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verify(mockOutputStream).write("24 25 26 27 28      ".getBytes());
        inOrder.verify(mockOutputStream).write(System.lineSeparator().getBytes());
        inOrder.verifyNoMoreInteractions();
        
        cal.printTo(System.out);
    }

    private Calendar februaryUsa(int year) {
        final Calendar date = Calendar.getInstance();
        date.set(year, Calendar.FEBRUARY, 1);
        date.setFirstDayOfWeek(SUNDAY);
        return date;
    }
    
    private Calendar februaryEu(int year) {
        final Calendar date = Calendar.getInstance();
        date.set(year, Calendar.FEBRUARY, 1);
        date.setFirstDayOfWeek(MONDAY);
        return date;
    }
}
