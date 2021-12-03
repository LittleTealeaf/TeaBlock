package Util;


/**
 * A factory that can include complex calculations of a certain vector whenever the {@link #get()} method is called. Subsequent methods return
 * instances that override this {@link #get()} method to add additional calculations.
 * @author Thomas Kwashnak
 */
public abstract class VectorFactory {

    public VectorFactory() {

    }

    public VectorFactory getAdd(VectorFactory other) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().add(other);
            }
        };
    }

    /**
     * If this object is a Vector object, it will clone it such that modifications do not affect the original values. If it is not an instance of a
     * vector, then it will simply just return the .get() method.
     * @return Vector used for calculations
     */
    public Vector getCloned() {
        if(this instanceof Vector) {
            return get().clone();
        } else {
            return get();
        }
    }

    public abstract Vector get();

    public VectorFactory getSubtract(VectorFactory other) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().subtract(other);
            }
        };
    }

    public VectorFactory getInverse() {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().inverse();
            }
        };
    }

    public VectorFactory getMultiply(double scale) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().multiply(scale);
            }
        };
    }

    public VectorFactory getDivide(double scale) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().divide(scale);
            }
        };
    }

    public VectorFactory getUnit() {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().unit();
            }
        };
    }

    public VectorFactory getAdd(double magnitude) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().add(magnitude);
            }
        };
    }

    public VectorFactory getSubtract(double magnitude) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().subtract(magnitude);
            }
        };
    }

    public VectorFactory getMultiply(VectorFactory scale) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().multiply(scale);
            }
        };
    }

    public VectorFactory getDivide(VectorFactory scale) {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().divide(scale);
            }
        };
    }

    public VectorFactory getAbsolute() {
        return new VectorFactory() {
            @Override
            public Vector get() {
                return VectorFactory.this.getCloned().absolute();
            }
        };
    }
}
