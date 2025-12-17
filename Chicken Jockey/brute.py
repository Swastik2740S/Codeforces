from collections import deque
from itertools import product

# Simulate one attack on stack configuration
# stacks: list of lists (each stack bottom-first)
# attack chooses stack s_idx and position p (0-based from bottom)

def simulate_attack(stacks, s_idx, p):
    stacks = [list(st) for st in stacks]
    st = stacks[s_idx]
    st[p] -= 1
    new_stacks = []
    # process possibly deaths in this stack
    # if st[p] <= 0 then remove that mob and split into below and above
    # below part remains as left stacks before s_idx, above part becomes new stack (mobs above)
    if st[p] > 0:
        stacks[s_idx] = st
        return stacks
    # else mob dies
    below = st[:p]
    above = st[p+1:]
    # left stacks remain stacks[:s_idx]
    left = stacks[:s_idx]
    # right stacks are stacks[s_idx+1:]
    right = stacks[s_idx+1:]
    # the mobs above fall down to form a new stack; but before that they take fall damage
    # The bottom mob in the new stack takes damage equal to number of mobs below it in previous stack (including the one that died)
    # That is: index of bottom in old stack is p+1 (0-based), and number below it was p+1 (including died)
    # However if above is empty, then nothing
    cur = above
    # We'll process cascade: while cur not empty and bottom dies from fall damage
    # When cur falls, bottom takes damage = len(below)+1? Wait careful
    # Actually when we killed st[p], the mobs above fall; the bottom of that new stack (which was st[p+1]) takes damage equal to number of mobs below it in previous stack, which is p+1
    # After that it may die; if it dies, the remaining above fall again and bottom takes damage equal to number of mobs below it in the previous stack (which was 1, since only that single mob was below it in the previous short stack)

    # Compose the "current previous below count" as follows:
    prev_stack = st  # previous stack when we removed element
    prev_below_counts = []
    # But easier: simulate as described in statement:
    # After removal, the above forms a stack. The bottom mob takes x damage where x = number of mobs below it in previous stack (including the one that died). For our p, that's p+1.
    # If it dies, then remaining take y damage where y = number of mobs below it in the previous stack. After first death, the previous stack was the above stack before, and the bottom of that had one mob below it (the one that died), so y=1. This repeats with y equal to 1 each subsequent fall.

    # So first fall damage is p+1, then if bottom dies, next fall damage is 1 repeatedly for subsequent removals.

    damage = p+1
    cur = list(cur)
    while True:
        if not cur:
            break
        cur[0] -= damage
        if cur[0] > 0:
            break
        # bottom dies
        cur = cur[1:]
        damage = 1
    # Now cur is resulting stack from the above part after cascade
    new_stacks = left + ([] if not below else [below]) + ([cur] if cur else []) + right
    # Note: below remains as separate stack (those below didn't fall)
    # But in statement, after killing mob inside a stack, all mobs on top fall down and form a new stack separate from below. So below stays as leftmost plus possibly below as last of left? Wait ordering: original stacks left + [below] + [cur] + right
    # We'll keep ordering as left then below (if any) then cur then right
    return new_stacks


def normalize(stacks):
    return tuple(tuple(st) for st in stacks if len(st)>0)


def min_attacks(init):
    start = (tuple(init),)
    start = tuple([tuple(init)])
    q = deque()
    q.append((start,0))
    seen = set([start])
    while q:
        stacks, d = q.popleft()
        # check if all dead
        if not stacks:
            return d
        # try all attacks: choose stack and position
        for si, st in enumerate(stacks):
            for p in range(len(st)):
                new = simulate_attack([list(s) for s in stacks], si, p)
                newt = normalize(new)
                if newt not in seen:
                    seen.add(newt)
                    q.append((newt, d+1))
    return None

if __name__ == '__main__':
    samples = [
        [3,1,4,1,2],
        [1,1,1,1],
        [1,2,1,3,5,2],
        [3,1,1,3,2,1],
        [1000000000,1000000000,1000000000]
    ]
    for arr in samples:
        print(arr, '->', min_attacks(arr))

    # random tests small
    import random
    random.seed(1)
    for n in range(2,7):
        for _ in range(20):
            arr = [random.randint(1,5) for _ in range(n)]
            val = min_attacks(arr)
            print('n',n,arr,val)
            # break

