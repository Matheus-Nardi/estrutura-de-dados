package sort.bubble;

public class Result {

    private int varreduras;
    private int comparações;
    private int trocas;

    public Result(int varreduras, int comparações, int trocas) {
        this.varreduras = varreduras;
        this.comparações = comparações;
        this.trocas = trocas;
    }

    public int getVarreduras() {
        return varreduras;
    }

    public void setVarreduras(int varreduras) {
        this.varreduras = varreduras;
    }

    public int getComparações() {
        return comparações;
    }

    public void setComparações(int comparações) {
        this.comparações = comparações;
    }

    public int getTrocas() {
        return trocas;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

    @Override
    public String toString() {
        return "Result [varreduras=" + varreduras + ", comparações=" + comparações + ", trocas=" + trocas + "]";
    }

}
