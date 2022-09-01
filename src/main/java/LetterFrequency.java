public enum LetterFrequency {

    A(8.15),
    B(0.97),
    C(3.15),
    D(3.73),
    E(17.39),
    F(1.12),
    G(0.97),
    H(0.85),
    I(7.31),
    J(0.45),
    K(0.02),
    L(5.69),
    M(2.87),
    N(7.12),
    O(5.28),
    P(2.80),
    Q(1.21),
    R(6.64),
    S(8.14),
    T(7.22),
    U(6.38),
    V(1.64),
    W(0.03),
    X(0.41),
    Y(0.28),
    Z(0.15);

    private double freq;

    LetterFrequency(double freq) {
        this.freq = freq;
    }

    public double getFreq() {
        return freq;
    }
}
