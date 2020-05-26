# GridSearch results

## MovieLens 1M dataset

### BeMF

```
Tuning parameters for BeMF recommender:

Best parameters set found on development set:

{numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.16, numFactors=2}

MAE scores on development set:

0.736607 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.16, numFactors=2}
0.737036 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.15000000000000002, numFactors=2}
0.737121 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.060000000000000005, numFactors=2}
0.737209 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.11, numFactors=2}
0.737290 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.04, numFactors=2}
0.737314 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.12, numFactors=2}
0.737368 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.14, numFactors=2}
0.737379 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.060000000000000005, numFactors=2}
0.737396 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.03, numFactors=2}
0.737420 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.19, numFactors=2}
0.737464 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.19, numFactors=2}
0.737478 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.13, numFactors=2}
0.737507 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.09, numFactors=2}
0.737570 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.06999999999999999, numFactors=2}
0.737572 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.2, numFactors=2}
0.737616 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.08, numFactors=2}
0.737735 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.17, numFactors=2}
0.737747 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.18000000000000002, numFactors=2}
0.737757 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.02, numFactors=2}
0.737762 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.12, numFactors=2}
0.737766 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.06999999999999999, numFactors=2}
0.737793 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.01, numFactors=2}
0.737795 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.2, numFactors=2}
0.737813 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.16, numFactors=2}
0.737836 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], learningRate=0.006, regularization=0.03, numFactors=2}
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=8}

MAE scores on development set:

0.718681 for {numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=8}
0.718801 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=8}
0.718810 for {numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.01, numFactors=8}
0.719177 for {numIters=50, lambda=0.055, seed=43, gamma=0.01, numFactors=8}
0.719208 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=8}
0.719788 for {numIters=50, lambda=0.06, seed=43, gamma=0.01, numFactors=8}
0.719954 for {numIters=50, lambda=0.030000000000000002, seed=43, gamma=0.01, numFactors=8}
0.720601 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=6}
0.720628 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=6}
0.720635 for {numIters=50, lambda=0.065, seed=43, gamma=0.01, numFactors=8}
```

### BiasedMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.01, numFactors=6}

MAE scores on development set:

0.708024 for {numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.01, numFactors=6}
0.708075 for {numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=6}
0.708153 for {numIters=50, lambda=0.055, seed=43, gamma=0.01, numFactors=6}
0.708342 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=6}
0.708465 for {numIters=50, lambda=0.06, seed=43, gamma=0.01, numFactors=6}
0.708558 for {numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.015, numFactors=6}
0.708576 for {numIters=50, lambda=0.055, seed=43, gamma=0.015, numFactors=6}
0.708752 for {numIters=50, lambda=0.045, seed=43, gamma=0.015, numFactors=6}
0.708801 for {numIters=50, lambda=0.06, seed=43, gamma=0.015, numFactors=6}
0.708821 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=6}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

0.751660 for {seed=43, numIters=50, numFactors=2}
0.769076 for {seed=43, numIters=50, numFactors=4}
0.772235 for {seed=43, numIters=50, numFactors=6}
0.779943 for {seed=43, numIters=50, numFactors=8}
0.780913 for {seed=43, numIters=50, numFactors=10}
```

### BNMF

```
Tuning parameters for BNMF recommender:

Best parameters set found on development set:

{numIters=50, seed=43, beta=5.0, alpha=0.6, numFactors=10}

MAE scores on development set:

0.691646 for {numIters=50, seed=43, beta=5.0, alpha=0.6, numFactors=10}
0.692656 for {numIters=50, seed=43, beta=5.0, alpha=0.7000000000000001, numFactors=10}
0.694478 for {numIters=50, seed=43, beta=5.0, alpha=0.8, numFactors=10}
0.695189 for {numIters=50, seed=43, beta=5.0, alpha=0.5, numFactors=10}
0.695498 for {numIters=50, seed=43, beta=5.0, alpha=0.6, numFactors=8}
0.695584 for {numIters=50, seed=43, beta=10.0, alpha=0.8, numFactors=4}
0.695970 for {numIters=50, seed=43, beta=10.0, alpha=0.6, numFactors=10}
0.696226 for {numIters=50, seed=43, beta=5.0, alpha=0.9, numFactors=10}
0.696490 for {numIters=50, seed=43, beta=5.0, alpha=0.7000000000000001, numFactors=8}
0.696797 for {numIters=50, seed=43, beta=15.0, alpha=0.8, numFactors=4}
```

### URP

```
Best parameters set found on development set:

{numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=10}

MAE scores on development set:

0.792035 for {numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=10}
0.794959 for {numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=2}
0.795050 for {numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=6}
0.795649 for {numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=4}
0.798221 for {numIters=50, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0], numFactors=8}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}

MAE scores on development set:

0.742856 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743028 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743189 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743536 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744209 for {numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744419 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744607 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.744706 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.744732 for {numIters=50, lambda=0.05, seed=43, gamma=0.0013, numFactors=4}
0.744798 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0013, numFactors=4}

```

## FilmTrust dataset

### BeMF

```
Best parameters set found on development set:

{numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.14, numFactors=2}

MAE scores on development set:

0.778503 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.14, numFactors=2}
0.778859 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.19, numFactors=2}
0.778921 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.16, numFactors=2}
0.779273 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.14, numFactors=2}
0.779489 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.13, numFactors=2}
0.779711 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.09, numFactors=2}
0.779744 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.02, numFactors=2}
0.779803 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.2, numFactors=2}
0.779917 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.09999999999999999, numFactors=2}
0.780025 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.16, numFactors=2}
0.780119 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.17, numFactors=2}
0.780182 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.12, numFactors=2}
0.780196 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.19, numFactors=2}
0.780205 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.02, numFactors=2}
0.780462 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.08, numFactors=2}
0.780479 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.11, numFactors=2}
0.780563 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.012, regularization=0.16, numFactors=2}
0.780623 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.19, numFactors=2}
0.780632 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.05, numFactors=2}
0.780844 for {numIters=100, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.03, numFactors=2}
0.780844 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.02, numFactors=2}
0.780899 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.18000000000000002, numFactors=2}
0.781145 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.08, numFactors=2}
0.781171 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.03, numFactors=2}
0.781186 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], learningRate=0.008, regularization=0.17, numFactors=2}
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=4}

MAE scores on development set:

0.846590 for {numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=4}
0.846833 for {numIters=50, lambda=0.095, seed=43, gamma=0.015, numFactors=4}
0.847251 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.015, numFactors=4}
0.847326 for {numIters=50, lambda=0.005, seed=43, gamma=0.015, numFactors=2}
0.847882 for {numIters=50, lambda=0.01, seed=43, gamma=0.015, numFactors=2}
0.847973 for {numIters=50, lambda=0.085, seed=43, gamma=0.015, numFactors=4}
0.848154 for {numIters=50, lambda=0.015, seed=43, gamma=0.02, numFactors=2}
0.848223 for {numIters=50, lambda=0.02, seed=43, gamma=0.02, numFactors=2}
0.848327 for {numIters=50, lambda=0.01, seed=43, gamma=0.02, numFactors=2}
0.848343 for {numIters=50, lambda=0.015, seed=43, gamma=0.015, numFactors=2}
```

### BiasedMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=2}

MAE scores on development set:

0.632835 for {numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=2}
0.633117 for {numIters=50, lambda=0.095, seed=43, gamma=0.015, numFactors=2}
0.633309 for {numIters=50, lambda=0.1, seed=43, gamma=0.02, numFactors=2}
0.633445 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.015, numFactors=2}
0.633679 for {numIters=50, lambda=0.095, seed=43, gamma=0.02, numFactors=2}
0.633814 for {numIters=50, lambda=0.085, seed=43, gamma=0.015, numFactors=2}
0.634113 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.02, numFactors=2}
0.634250 for {numIters=50, lambda=0.08, seed=43, gamma=0.015, numFactors=2}
0.634643 for {numIters=50, lambda=0.085, seed=43, gamma=0.02, numFactors=2}
0.634698 for {numIters=50, lambda=0.1, seed=43, gamma=0.01, numFactors=2}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

0.829119 for {seed=43, numIters=50, numFactors=2}
0.848695 for {seed=43, numIters=50, numFactors=4}
0.855264 for {seed=43, numIters=50, numFactors=6}
0.867049 for {seed=43, numIters=50, numFactors=10}
0.879115 for {seed=43, numIters=50, numFactors=8}
```

### BNMF

```
Best parameters set found on development set:

{numIters=50, seed=43, beta=25.0, alpha=0.4, numFactors=10}

MAE scores on development set:

0.679837 for {numIters=50, seed=43, beta=25.0, alpha=0.4, numFactors=10}
0.681266 for {numIters=50, seed=43, beta=25.0, alpha=0.5, numFactors=8}
0.681905 for {numIters=50, seed=43, beta=25.0, alpha=0.6, numFactors=8}
0.682480 for {numIters=50, seed=43, beta=25.0, alpha=0.6, numFactors=10}
0.683645 for {numIters=50, seed=43, beta=25.0, alpha=0.7000000000000001, numFactors=10}
0.683669 for {numIters=50, seed=43, beta=25.0, alpha=0.5, numFactors=10}
0.688081 for {numIters=50, seed=43, beta=20.0, alpha=0.5, numFactors=8}
0.688509 for {numIters=50, seed=43, beta=20.0, alpha=0.6, numFactors=10}
0.688790 for {numIters=50, seed=43, beta=25.0, alpha=0.30000000000000004, numFactors=10}
0.689080 for {numIters=50, seed=43, beta=25.0, alpha=0.7000000000000001, numFactors=8}
```

### URP

```
Best parameters set found on development set:

{numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=4}

MAE scores on development set:

0.829682 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=4}
0.829901 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=6}
0.830540 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=2}
0.831135 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=10}
0.839010 for {numIters=50, seed=43, ratings=[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0], numFactors=8}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}

MAE scores on development set:

0.657489 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.658202 for {numIters=50, lambda=0.09, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.659117 for {numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.659926 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0013, numFactors=2}
0.660287 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.660770 for {numIters=50, lambda=0.09, seed=43, gamma=0.0013, numFactors=2}
0.661809 for {numIters=50, lambda=0.08, seed=43, gamma=0.0013, numFactors=2}
0.661934 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.662801 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0012000000000000001, numFactors=2}
0.663125 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0013, numFactors=2}
```

## MyAnimeList

### BeMF

```
Best parameters set found on development set:

{numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.09999999999999999, numFactors=4}

MAE scores on development set:

0.986767 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.09999999999999999, numFactors=4}
0.986879 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.18000000000000002, numFactors=4}
0.989344 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.19, numFactors=4}
0.989755 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.2, numFactors=4}
0.990111 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.05, numFactors=4}
0.990156 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.15000000000000002, numFactors=4}
0.990701 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.06999999999999999, numFactors=4}
0.990917 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.01, numFactors=4}
0.991909 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.16, numFactors=4}
0.992160 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.060000000000000005, numFactors=4}
0.992406 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.14, numFactors=4}
0.992735 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.09, numFactors=4}
0.992789 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.12, numFactors=4}
0.993049 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.17, numFactors=4}
0.993435 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.15000000000000002, numFactors=4}
0.993699 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.02, numFactors=4}
0.994662 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.11, numFactors=4}
0.994794 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.03, numFactors=4}
0.995190 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.03, numFactors=4}
0.995226 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.08, numFactors=4}
0.995760 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.13, numFactors=4}
0.995905 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.11, numFactors=4}
0.996425 for {numIters=100, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.09, numFactors=4}
0.996527 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.14, numFactors=4}
0.996545 for {numIters=75, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], learningRate=0.004, regularization=0.060000000000000005, numFactors=4}
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.085, seed=43, gamma=0.005, numFactors=10}

MAE scores on development set:

1.100057 for {numIters=50, lambda=0.085, seed=43, gamma=0.005, numFactors=10}
1.100132 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.005, numFactors=10}
1.100141 for {numIters=50, lambda=0.08, seed=43, gamma=0.005, numFactors=10}
1.100348 for {numIters=50, lambda=0.095, seed=43, gamma=0.005, numFactors=10}
1.100388 for {numIters=50, lambda=0.07500000000000001, seed=43, gamma=0.005, numFactors=10}
1.100703 for {numIters=50, lambda=0.1, seed=43, gamma=0.005, numFactors=10}
1.100796 for {numIters=50, lambda=0.07, seed=43, gamma=0.005, numFactors=10}
1.101299 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.005, numFactors=4}
1.101319 for {numIters=50, lambda=0.04, seed=43, gamma=0.005, numFactors=4}
1.101346 for {numIters=50, lambda=0.030000000000000002, seed=43, gamma=0.005, numFactors=4}
```

### BiasedMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.085, seed=43, gamma=0.01, numFactors=10}

MAE scores on development set:

0.923536 for {numIters=50, lambda=0.085, seed=43, gamma=0.01, numFactors=10}
0.923537 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.01, numFactors=10}
0.923695 for {numIters=50, lambda=0.08, seed=43, gamma=0.01, numFactors=10}
0.923696 for {numIters=50, lambda=0.095, seed=43, gamma=0.01, numFactors=10}
0.924014 for {numIters=50, lambda=0.1, seed=43, gamma=0.01, numFactors=10}
0.924025 for {numIters=50, lambda=0.07500000000000001, seed=43, gamma=0.01, numFactors=10}
0.924484 for {numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=10}
0.924523 for {numIters=50, lambda=0.095, seed=43, gamma=0.015, numFactors=10}
0.924536 for {numIters=50, lambda=0.07, seed=43, gamma=0.01, numFactors=10}
0.924728 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.015, numFactors=10}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

1.120250 for {seed=43, numIters=50, numFactors=2}
1.150784 for {seed=43, numIters=50, numFactors=4}
1.175432 for {seed=43, numIters=50, numFactors=6}
1.186780 for {seed=43, numIters=50, numFactors=8}
1.190961 for {seed=43, numIters=50, numFactors=10}
```

### BNMF

```
Best parameters set found on development set:

{numIters=50, seed=43, beta=5.0, alpha=0.5, numFactors=4}

MAE scores on development set:

0.955203 for {numIters=50, seed=43, beta=5.0, alpha=0.5, numFactors=4}
0.956461 for {numIters=50, seed=43, beta=5.0, alpha=0.4, numFactors=8}
0.956706 for {numIters=50, seed=43, beta=5.0, alpha=0.4, numFactors=4}
0.957805 for {numIters=50, seed=43, beta=5.0, alpha=0.6, numFactors=4}
0.958651 for {numIters=50, seed=43, beta=10.0, alpha=0.5, numFactors=4}
0.958710 for {numIters=50, seed=43, beta=5.0, alpha=0.5, numFactors=8}
0.959690 for {numIters=50, seed=43, beta=5.0, alpha=0.5, numFactors=6}
0.960343 for {numIters=50, seed=43, beta=10.0, alpha=0.4, numFactors=4}
0.961706 for {numIters=50, seed=43, beta=15.0, alpha=0.5, numFactors=4}
0.961723 for {numIters=50, seed=43, beta=10.0, alpha=0.6, numFactors=4}
```

### URP

```
Best parameters set found on development set:

{numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=10}

MAE scores on development set:

1.153224 for {numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=10}
1.154962 for {numIters=25, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=10}
1.155060 for {numIters=25, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=4}
1.155287 for {numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=4}
1.155991 for {numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=6}
1.156052 for {numIters=15, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=10}
1.156780 for {numIters=25, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=6}
1.158124 for {numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=2}
1.158933 for {numIters=25, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=2}
1.159956 for {numIters=35, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=8}
1.160004 for {numIters=15, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=2}
1.161208 for {numIters=15, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=4}
1.161336 for {numIters=25, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=8}
1.162446 for {numIters=15, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=6}
1.178189 for {numIters=15, seed=43, ratings=[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], numFactors=8}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=4}

MAE scores on development set:

0.951791 for {numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.952106 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.952280 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.952644 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.952884 for {numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.952950 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.953211 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.953589 for {numIters=50, lambda=0.01, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.953597 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.953782 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}

```

# Reliability Prediction Improvement (RPI)

| Dataset     | BeMF (native)       | BeMF (enforced)     |
| ----------- | ------------------- | ------------------- |
| MovieLens   | 0.09344191434718613 | 0.03607168687625841 |
| FilmTrust   | 0.17187947751547360 | 0.03277490814437404 |
| MyAnimeList | 0.17087788625426540 | 0.03386983091491235 |
