package org.dsa.iot.historian.stats.rollup;

import org.dsa.iot.dslink.node.value.Value;

/**
 * @author Samuel Grenier
 */
public class MinRollup extends Rollup {

    private Number number;

    @Override
    public void reset() {
        number = null;
    }

    @Override
    public void update(Value value, long ts) {
        Number num = value.getNumber();
        if (number == null) {
            number = num;
        } else if (num != null) {
            double a = num.doubleValue();
            double b = number.doubleValue();
            number = Math.min(a, b);
        }
    }

    @Override
    public Value getValue() {
        return new Value(number);
    }
}
